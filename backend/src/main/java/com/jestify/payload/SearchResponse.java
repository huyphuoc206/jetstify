package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class SearchResponse {
    private List<SongResponse> songResponseList;
    private List<ArtistResponse> artistResponseList;
    private List<PodcastResponse> podcastResponseList;
}
