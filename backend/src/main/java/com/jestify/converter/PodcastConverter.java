package com.jestify.converter;

import com.jestify.entity.Podcasts;
import com.jestify.payload.PodcastResponse;
import org.springframework.stereotype.Component;


@Component
public class PodcastConverter {
    public PodcastResponse toResponse(Podcasts entity) {
        return PodcastResponse.builder()
                .thumbnail(entity.getThumbnail())
                .podcastId(entity.getId())
                .description(entity.getDescription())
                .namePodcast(entity.getName())
                .build();

    }
}
