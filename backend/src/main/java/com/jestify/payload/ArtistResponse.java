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
    private List<ArtistPhotoReponse> photos;
}
