package com.jestify.service;

import com.jestify.converter.PodcastConverter;
import com.jestify.entity.Podcasts;
import com.jestify.payload.EpisodeResponse;
import com.jestify.payload.PodcastResponse;
import com.jestify.repository.PodcastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PodcastService {
    private final EpisodeService episodeService;
    private final PodcastRepository podcastRepository;
    private final PodcastConverter podcastConverter;
    public List<EpisodeResponse> getPodcastEpisode(Long podcastId) {
        return episodeService.getEpisodeByIdPodcast(podcastId);
    }
    public PodcastResponse getPodcastById(Long podcastId) {
        Podcasts podcasts = podcastRepository.findById(podcastId)
                .orElseThrow(() -> new IllegalStateException("Artist not found"));
        PodcastResponse podcastResponse = podcastConverter.toResponse(podcasts);
        return podcastResponse;
    }
}
