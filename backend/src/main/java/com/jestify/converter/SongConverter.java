package com.jestify.converter;

import com.jestify.entity.Songs;
import com.jestify.payload.SongRequest;
import com.jestify.payload.SongResponse;
import org.springframework.stereotype.Component;

@Component
public class SongConverter {
    public SongResponse toResponse(Songs entity) {
        return SongResponse.builder()
                .thumbnail(entity.getThumbnail())
                .img(entity.getImg())
                .time(entity.getTime())
                .link(entity.getLink())
                .name(entity.getName())
                .build();
    }
    public Songs toEntity(SongRequest request){
        return Songs.builder().build();

    }
}
