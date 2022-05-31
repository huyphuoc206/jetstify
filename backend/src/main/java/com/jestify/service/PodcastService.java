package com.jestify.service;

import com.jestify.payload.PodcastEpisodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PocastService {
    private final PodcastEpisodeService podcastEpisodeService;
    public List<PodcastEpisodeResponse> getPodcastEpisode(Long artistId) {
        return podcastEpisodeService.getPodcastEpisodeByIdArtist(artistId);
    }
}
