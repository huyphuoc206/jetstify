package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PlaylistRequest {
    private String name;
    private String nameUserCreate;
    private String thumbnail;
    private String description;
    private Long playlistId;
    private Long songId;
    private List<SongResponse> listSongResponse;
}
