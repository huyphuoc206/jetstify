package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ArtistPhotoReponse {
    private String link;
    private Long photoId;
}
