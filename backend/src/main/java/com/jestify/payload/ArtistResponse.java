package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class ArtistResponse {
    private String thumbnail;
    private boolean verify;
    private String facebook;
    private String instagram;
    private String twitter;
    private Long artistId;
    private String nickName;
    private String info;
    private Long followId;
    private List<ArtistPhotoReponse> photos;
    private List<SongResponse> songResponseList;
    private String fullNameUser;
    private int totalFollowers;
}
