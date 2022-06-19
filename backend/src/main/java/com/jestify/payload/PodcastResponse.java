package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Builder
@Setter
@Getter
public class PodcastResponse {

    private Long podcastId;
    private String thumbnail;
    private String namePodcast;
    private String fullNameUser;
    private String description;
    private Long followId;
    private List<EpisodeResponse> episodeResponseList;
}

