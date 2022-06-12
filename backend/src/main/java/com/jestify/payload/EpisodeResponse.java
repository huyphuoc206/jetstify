package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class EpisodeResponse {
    private Long episodeId;
    private Long podcastId;
    private String name;
    private String link;
    private String thumbnail;
    private String description;
    private Date createdDate;
}
