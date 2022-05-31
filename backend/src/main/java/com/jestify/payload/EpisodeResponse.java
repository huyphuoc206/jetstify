package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PodcastEpisodeResponse {
    private Long podcastId;
    private String name;
    private String link;
    private String thumbnail;
    private String description;
}
