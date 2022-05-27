package com.jestify.payload;

import com.jestify.entity.Socials;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class ArtistResponse {
    private int follow;
    private String thumbnail;
    private Long artistId;
    private String name;
    private String info;
    private List<SocialResponse> socials;
    private List<ImageReponse> images;
}
