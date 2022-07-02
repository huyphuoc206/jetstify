package com.jestify.service;

import com.jestify.converter.ArtistConverter;
import com.jestify.converter.PodcastConverter;
import com.jestify.converter.SongConverter;
import com.jestify.entity.Artists;
import com.jestify.entity.Podcasts;
import com.jestify.entity.Songs;
import com.jestify.payload.ArtistResponse;
import com.jestify.payload.HomeResponse;
import com.jestify.payload.PodcastResponse;
import com.jestify.payload.SongResponse;
import com.jestify.repository.ArtistRepository;
import com.jestify.repository.PodcastRepository;
import com.jestify.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final SongRepository songRepository;
    private final PodcastRepository podcastRepository;
    private final ArtistRepository artistRepository;
    private final SongConverter songConverter;
    private final PodcastConverter podcastConverter;
    private final ArtistConverter artistConverter;

    public HomeResponse getDataHome() {
        HomeResponse homeResponse = HomeResponse.builder().build();
        List<SongResponse> songsRandomList = songRepository
                .findRandomSongs()
                .stream()
                .map(songConverter::toResponse)
                .collect(Collectors.toList());
        List<PodcastResponse> podcastsRandomList = podcastRepository
                .findRandomPodcasts()
                .stream()
                .map(podcastConverter::toResponse)
                .collect(Collectors.toList());
        List<ArtistResponse> artistsRandomList = artistRepository
                .findRandomArtists()
                .stream().map(artistConverter::toResponse)
                .collect(Collectors.toList());
        homeResponse.setListSongRandom(songsRandomList);
        homeResponse.setListArtistRandom(artistsRandomList);
        homeResponse.setListPodcastRandom(podcastsRandomList);
        return homeResponse;
    }
}
