package com.jestify.converter;

import com.jestify.entity.Images;
import com.jestify.payload.ImageReponse;
import org.springframework.stereotype.Component;

@Component
public class ImageConverter {
    public ImageReponse toResponse(Images entity){
        return ImageReponse.builder()
                .link(entity.getLink())
                .imageId(entity.getId())

                .build();
    }
}
