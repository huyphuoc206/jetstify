package com.jestify.converter;

import com.jestify.entity.Artists;
import com.jestify.payload.ArtistResponse;
import org.springframework.stereotype.Component;

@Component
public class ArtistConverter {


    public ArtistResponse toResponse(Artists entity) {
        return ArtistResponse.builder()
                .artistId(entity.getId())
                .follow(entity.getFollow())
                .build();

    }
}
