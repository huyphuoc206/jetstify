package com.jestify.converter;

import com.jestify.entity.Artists;
import com.jestify.entity.Users;
import com.jestify.payload.ArtistRequest;
import com.jestify.payload.ArtistResponse;
import com.jestify.payload.UserRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;


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
    public Artists toEntity (ArtistRequest artistRequest){
        return Artists.builder()
                .nickName(artistRequest.getNickName())
                .build();
    }
}
