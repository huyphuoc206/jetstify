package com.jestify.service;

import com.jestify.converter.PlaylistConverter;
import com.jestify.converter.SongConverter;
import com.jestify.entity.Playlists;
import com.jestify.entity.Songs;
import com.jestify.payload.PlaylistRequest;
import com.jestify.payload.PlaylistResponse;
import com.jestify.payload.SongResponse;
import com.jestify.repository.PlaylistRepository;
import com.jestify.repository.SongRepository;
import com.jestify.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistConverter playlistConverter;
    private final PlaylistRepository playlistRepository;
    private final SongConverter songConverter;
    private final SongRepository songRepository;

    public List<PlaylistResponse> getListPlaylistByUserPresent() {
        String emailUser = UserUtil.getUserCurrently();
        List<PlaylistResponse> playlistResponses = playlistRepository
                .findByCreatedByOrderByIdDesc(emailUser)
                .stream()
                .map(playlistConverter::toResponse)
                .collect(Collectors.toList());
        return playlistResponses;

    }

    public PlaylistResponse getPlayListById(Long playlistId) {
        Playlists playlists = playlistRepository.findById(playlistId).orElse(null);
        PlaylistResponse playlistResponse = playlistConverter.toResponse(playlists);
        List<SongResponse> songResponseList = songRepository
                .findByPlaylists_idAndActiveTrue(playlists.getId())
                .stream()
                .map(songConverter::toResponse)
                .collect(Collectors.toList());
        playlistResponse.setSongResponseList(songResponseList);
        return playlistResponse;
    }

    public PlaylistResponse createPlaylist() {
        PlaylistRequest playlistRequest = PlaylistRequest.builder().build();
        int indexPlaylist = getListPlaylistByUserPresent().size() + 1;
        playlistRequest.setName("My Playlist #" + indexPlaylist);

        Playlists playlists = playlistRepository.save(playlistConverter.toEntity(playlistRequest));
        return playlistConverter.toResponse(playlists);
    }

    public void updatePlaylist(Long id, PlaylistRequest playlistRequest) {
        Playlists playlists = playlistRepository.findById(id).orElse(null);
        playlistConverter.toEntity(playlistRequest);
        playlistRepository.save(playlists);
    }

    public void deletePlaylist(Long id) {
        Playlists playlists = playlistRepository.findById(id).orElse(null);
        playlists.setActive(false);
        playlistRepository.save(playlists);

    }

    public void addSongToPlaylist(Long songId, Long playlistId) {
        Songs songs = songRepository.findById(songId).orElse(null);
        Playlists playlists = playlistRepository.findById(playlistId).orElse(null);
        playlists.getSongs().add(songs);
        playlistRepository.save(playlists);
    }
}
