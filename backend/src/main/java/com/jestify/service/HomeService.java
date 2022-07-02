package com.jestify.service;

import com.jestify.common.AppConstant;
import com.jestify.converter.ArtistConverter;
import com.jestify.converter.PodcastConverter;
import com.jestify.converter.SongConverter;
import com.jestify.payload.ArtistResponse;
import com.jestify.payload.HomeResponse;
import com.jestify.payload.PodcastResponse;
import com.jestify.payload.SongResponse;
import com.jestify.repository.ArtistRepository;
import com.jestify.repository.FollowRepository;
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
    private final FollowRepository followRepository;
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

        List<SongResponse> songsNewList = songRepository
                .findSongsNew()
                .stream()
                .map(songConverter::toResponse)
                .collect(Collectors.toList());
        List<PodcastResponse> podcastsNewList = podcastRepository
                .findPodcastsNew()
                .stream()
                .map(podcastConverter::toResponse)
                .collect(Collectors.toList());
        List<ArtistResponse> artistsNewList = artistRepository
                .findSongNew()
                .stream().map(artistConverter::toResponse)
                .collect(Collectors.toList());
        List<Long> listArtistFollows = followRepository.findByFollowers(AppConstant.ARTIST);
        List<Long> listPodcastFollows = followRepository.findByFollowers(AppConstant.PODCAST);
        List<ArtistResponse> artistsPopularList = listArtistFollows
                .stream()
                .map(artistId -> artistConverter
                        .toResponse(artistRepository
                                .findById(artistId).orElse(null)))
                .collect(Collectors.toList());

        List<PodcastResponse> podcastsPopularList = listPodcastFollows
                .stream()
                .map(podcastId -> podcastConverter
                        .toResponse(podcastRepository
                                .findById(podcastId).orElse(null)))
                .collect(Collectors.toList());

        homeResponse.setListSongRandom(songsRandomList);
        homeResponse.setListArtistRandom(artistsRandomList);
        homeResponse.setListPodcastRandom(podcastsRandomList);

        homeResponse.setListSongNew(songsNewList);
        homeResponse.setListArtistNew(artistsNewList);
        homeResponse.setListPodcastNew(podcastsNewList);

        homeResponse.setListArtistFollowManyLikes(artistsPopularList);
        homeResponse.setListPodcastFollowManyLikes(podcastsPopularList);
        return homeResponse;
    }
}
