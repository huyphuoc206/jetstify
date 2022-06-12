package com.jestify.converter;

import com.jestify.entity.Podcasts;
import com.jestify.payload.EpisodeResponse;
import com.jestify.payload.PodcastResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
