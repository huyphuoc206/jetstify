package com.jestify.payload;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistRequest {
    private String name;
    private String nameUserCreate;
    private String thumbnail;
    private String description;
    private Long playlistId;
    private Long songId;
    private List<SongResponse> listSongResponse;
}
