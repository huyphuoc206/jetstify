package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class HomeResponse {
    private List<SongResponse> listSongRandom;
    private List<SongResponse> listSongNew;
    private List<PodcastResponse> listPodcastRandom;
    private List<PodcastResponse> listPodcastFollowManyLikes;
    private List<PodcastResponse> listPodcastNew;
    private List<ArtistResponse> listArtistRandom;
    private List<ArtistResponse> listArtistFollowManyLikes;
    private List<ArtistResponse> listArtistNew;
}
