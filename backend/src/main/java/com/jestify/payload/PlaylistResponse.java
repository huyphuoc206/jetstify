package com.jestify.payload;

import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistResponse {
    private String namePlaylist;
    private String nameUserCreate;
    private String thumbnail;
    private String description;
    private Long idPlaylist;
    private String idUser;
    private List<SongResponse> songResponseList;
}
