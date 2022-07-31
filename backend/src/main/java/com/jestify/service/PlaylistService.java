package com.jestify.service;

import com.jestify.converter.PlaylistConverter;
import com.jestify.converter.SongConverter;
import com.jestify.entity.Artists;
import com.jestify.entity.Playlists;
import com.jestify.entity.Songs;
import com.jestify.entity.Users;
import com.jestify.payload.PlaylistRequest;
import com.jestify.payload.PlaylistResponse;
import com.jestify.payload.PodcastRequest;
import com.jestify.payload.SongResponse;
import com.jestify.repository.ArtistRepository;
import com.jestify.repository.PlaylistRepository;
import com.jestify.repository.SongRepository;
import com.jestify.repository.UserRepository;
import com.jestify.utils.AmazonUtil;
import com.jestify.utils.JsonUtil;
import com.jestify.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistConverter playlistConverter;
    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;
    private final SongConverter songConverter;
    private final SongRepository songRepository;
    private final AmazonUtil amazonUtil;
    private final ArtistRepository artistRepository;

    public List<PlaylistResponse> getListPlaylistByUserPresent() {
        String emailUser = UserUtil.getUserCurrently();
        List<PlaylistResponse> playlistResponses = playlistRepository
                .findByCreatedByAndActiveTrueOrderByIdDesc(emailUser)
                .stream()
                .map(playlistConverter::toResponse)
                .collect(Collectors.toList());
        return playlistResponses;

    }

    public PlaylistResponse getPlayListById(Long playlistId) {
        Playlists playlists = playlistRepository.findByIdAndActiveTrue(playlistId).orElse(null);
        PlaylistResponse playlistResponse = playlistConverter.toResponse(playlists);
        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElse(null);
        List<SongResponse> songResponseList = songRepository
                .findByPlaylists_idAndActiveTrue(playlists.getId())
                .stream()
                .map(e -> {
                    Artists artists = artistRepository.findByUserId(users.getId()).orElseThrow(() -> new IllegalStateException("Not Found Artist"));
                    SongResponse songResponse = songConverter.toResponse(e);
                    songResponse.setNameArtist(artists.getNickName());
                    return songResponse;
                })
                .collect(Collectors.toList());
        playlistResponse.setSongResponseList(songResponseList);
        playlistResponse.setNameUserCreate(users.getFullName());
        return playlistResponse;
    }

    public PlaylistResponse createPlaylist() {
        PlaylistRequest playlistRequest = PlaylistRequest.builder().build();
        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElse(null);
        int indexPlaylist = getListPlaylistByUserPresent().size() + 1;
        playlistRequest.setName("My Playlist #" + indexPlaylist);

        Playlists playlists = playlistRepository.save(playlistConverter.toEntity(playlistRequest));
        PlaylistResponse playlistResponse = playlistConverter.toResponse(playlists);
        playlistResponse.setNameUserCreate(users.getFullName());
        return playlistResponse;
    }
    @Transactional
    public void updatePlaylist(Long id, String playlistRequestJson, MultipartFile fileImg) {
        PlaylistRequest playlistRequest = JsonUtil.toObject(playlistRequestJson, PlaylistRequest.class);
        Playlists playlists = playlistRepository.findById(id).orElseThrow(() -> new IllegalStateException("Not Found User"));
        playlists.setName(playlistRequest.getName());
        if(fileImg != null) {
            playlists.setThumbnail(amazonUtil.uploadFile(fileImg));
        }

        playlists.setDescription(playlistRequest.getDescription());
        playlistRepository.save(playlists);
    }

    public void deletePlaylist(Long id) {
        Playlists playlists = playlistRepository.findById(id).orElse(null);
        playlists.setActive(false);
        playlistRepository.save(playlists);

    }

    public void addSongToPlaylist(Long songId, Long playlistId) {
        Songs songs = songRepository.findSongById(songId).orElseThrow(()-> new IllegalStateException("Song Not Found"));
        Playlists playlists = playlistRepository.findByIdAndActiveTrue(playlistId).orElseThrow(()-> new IllegalStateException("Playlist Not Found"));
        Songs existSong = playlists.getSongs().stream()
                .filter(song -> song.getId().equals(songId))
                .findAny()
                .orElse(null);
        if (existSong == null) {
            playlists.getSongs().add(songs);
            playlistRepository.save(playlists);
        } else {
            throw  new IllegalStateException("Song existed in this playlist");
        }
    }
}
