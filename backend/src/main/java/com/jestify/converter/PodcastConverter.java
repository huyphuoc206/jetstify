package com.jestify.converter;


import com.jestify.entity.Podcasts;
import com.jestify.payload.PodcastResponse;
import org.springframework.stereotype.Component;

@Component
public class PodcastConverter {
        public PodcastResponse toResponse(Podcasts entity){
            return PodcastResponse
                    .builder()
                    .description(entity.getDescription())
                    .podcastId(entity.getId())
                    .link(entity.getLink())
                    .name(entity.getName())
                    .thumbnail(entity.getThumbnail())
                    .build();
        }

}
