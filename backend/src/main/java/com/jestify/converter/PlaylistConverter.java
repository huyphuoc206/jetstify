package com.jestify.converter;

import com.jestify.entity.Playlists;
import com.jestify.payload.PlaylistRequest;
import com.jestify.payload.PlaylistResponse;
import org.springframework.stereotype.Component;

@Component
public class PlaylistConverter {
    public PlaylistResponse toResponse(Playlists entity){
        return PlaylistResponse
                .builder()
                .idPlaylist(entity.getId())
                .namePlaylist(entity.getName())
                .description(entity.getDescription())
                .thumbnail(entity.getThumbnail())
                .build();
    }
    public Playlists toEntity(PlaylistRequest playlistRequest){
        return Playlists
                .builder()
                .name(playlistRequest.getName())
                .thumbnail(playlistRequest.getThumbnail())
                .description(playlistRequest.getDescription())
                .active(true)
                .build();
    }
}
