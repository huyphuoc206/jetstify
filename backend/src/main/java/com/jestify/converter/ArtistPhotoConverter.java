package com.jestify.converter;

import com.jestify.entity.ArtistPhoto;
import com.jestify.payload.ArtistPhotoReponse;
import org.springframework.stereotype.Component;

@Component
public class ArtistPhotoConverter {
    public ArtistPhotoReponse toResponse(ArtistPhoto entity){
        return ArtistPhotoReponse.builder()
                .link(entity.getLink())
                .photoId(entity.getId())
                .build();
    }
}
