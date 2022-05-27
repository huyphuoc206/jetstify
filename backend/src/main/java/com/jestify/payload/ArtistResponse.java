package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ArtistResponse {
    private int follow;
    private Long artistId;
}
