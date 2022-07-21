package com.jestify.service;

import com.jestify.converter.PlaylistConverter;
import com.jestify.entity.Playlists;
import com.jestify.entity.Users;
import com.jestify.payload.PlaylistRequest;
import com.jestify.payload.PlaylistResponse;
import com.jestify.repository.PlaylistRepository;
import com.jestify.repository.UserRepository;
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
    private final UserRepository userRepository;

    public List<PlaylistResponse> getListPlaylistByUserPresent() {
        String emailUser = UserUtil.getUserCurrently();
        List<PlaylistResponse> playlistResponses = playlistRepository
                .findByCreatedBy(emailUser)
                .stream()
                .map(playlistConverter::toResponse)
                .collect(Collectors.toList());
        return playlistResponses;

    }
    public PlaylistResponse getPlayListById(Long playlistId){
        Playlists playlists = playlistRepository.findById(playlistId).orElse(null);
        PlaylistResponse playlistResponse = playlistConverter.toResponse(playlists);
        return playlistResponse;
    }
    public PlaylistResponse createPlaylist(){
        PlaylistRequest playlistRequest = PlaylistRequest.builder().build();
        int indexPlaylist = getListPlaylistByUserPresent().size() + 1;
        playlistRequest.setName("My Playlist #" + indexPlaylist );

        Playlists playlists = playlistRepository.save(playlistConverter.toEntity(playlistRequest));
        return playlistConverter.toResponse(playlists);
    }
    public void updatePlaylist(Long id,PlaylistRequest playlistRequest){
        Playlists playlists = playlistRepository.findById(id).orElse(null);
        playlistConverter.toEntity(playlistRequest);
        playlistRepository.save(playlists);
    }
    public void deletePlaylist(Long id){
        Playlists playlists = playlistRepository.findById(id).orElse(null);
        playlists.setActive(false);
        playlistRepository.save(playlists);

    }
}
