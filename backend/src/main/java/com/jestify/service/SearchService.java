package com.jestify.service;

import com.jestify.converter.ArtistConverter;
import com.jestify.converter.PodcastConverter;
import com.jestify.converter.SongConverter;
import com.jestify.payload.ArtistResponse;
import com.jestify.payload.PodcastResponse;
import com.jestify.payload.SearchResponse;
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
public class SearchService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final PodcastRepository podcastRepository;
    private final SongConverter songConverter;
    private final ArtistConverter artistConverter;
    private final PodcastConverter podcastConverter;

    public SearchResponse searchResponses(String name) {
        SearchResponse searchResponse = SearchResponse.builder().build();
        List<SongResponse> songsResponses = songRepository
                .findByNameContainingIgnoreCaseAndActiveTrue(name)
                .stream()
                .map(songConverter::toResponse)
                .collect(Collectors.toList());
        List<ArtistResponse> artistResponses = artistRepository
                .findByNickNameContainingIgnoreCaseAndVerifyTrue(name)
                .stream()
                .map(artistConverter::toResponse)
                .collect(Collectors.toList());
        List<PodcastResponse> podcastResponses = podcastRepository
                .findByNameContainingIgnoreCaseAndActiveTrue(name)
                .stream()
                .map(podcastConverter::toResponse)
                .collect(Collectors.toList());
        searchResponse.setSongResponseList(songsResponses);
        searchResponse.setArtistResponseList(artistResponses);
        searchResponse.setPodcastResponseList(podcastResponses);
        return searchResponse;
    }
}
