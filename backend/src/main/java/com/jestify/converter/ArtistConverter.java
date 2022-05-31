package com.jestify.converter;

import com.jestify.entity.Artists;
import com.jestify.payload.ArtistResponse;
import org.springframework.stereotype.Component;


@Component
public class ArtistConverter {

    public ArtistResponse toResponse(Artists entity) {
        return ArtistResponse.builder()
                .thumbnail(entity.getThumbnail())
                .artistId(entity.getId())
                .nickName(entity.getNickName())
                .info(entity.getInfo())
                .facebook(entity.getFacebook())
                .instagram(entity.getInstagram())
                .twitter(entity.getTwitter())
                .info(entity.getInfo())
                .build();

    }
}
