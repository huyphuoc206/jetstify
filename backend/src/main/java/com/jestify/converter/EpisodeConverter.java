package com.jestify.converter;


import com.jestify.entity.Episodes;
import com.jestify.payload.EpisodeResponse;
import org.springframework.stereotype.Component;

@Component
public class EpisodeConverter {
        public EpisodeResponse toResponse(Episodes entity){
            return EpisodeResponse
                    .builder()
                    .description(entity.getDescription())
                    .podcastId(entity.getId())
                    .link(entity.getLink())
                    .name(entity.getName())
                    .thumbnail(entity.getThumbnail())
                    .build();
        }

}
