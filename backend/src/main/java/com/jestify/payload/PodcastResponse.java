package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Builder
@Setter
@Getter
public class PodcastResponse {
    private String thumbnail;
    private Long podcastId;
    private String name;
    private String description;
    private List<EpisodeResponse> episodeResponseList;
}

