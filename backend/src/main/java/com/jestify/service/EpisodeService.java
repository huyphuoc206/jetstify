package com.jestify.service;

import com.jestify.converter.EpisodeConverter;
import com.jestify.entity.Episodes;
import com.jestify.payload.EpisodeResponse;
import com.jestify.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {
    public final EpisodeRepository episodeRepository;
    public final EpisodeConverter episodeConverter;

    public List<EpisodeResponse> getEpisodeByIdPodcast(Long podcastId) {
        List<EpisodeResponse> podcastResponse = new ArrayList<>();
        List<Episodes> podcasts = episodeRepository.findByPodcasts_idAndActive(podcastId, true);
        for (Episodes podcast : podcasts) {
            podcastResponse.add(episodeConverter.toResponse(podcast));
        }
        return podcastResponse;
    }
}
