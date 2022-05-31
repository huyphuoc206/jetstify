package com.jestify.service;

import com.jestify.converter.PodcastEpisodeConverter;
import com.jestify.entity.PodcastEpisode;
import com.jestify.payload.PodcastEpisodeResponse;
import com.jestify.repository.PodcastEpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PodcastEpisodeService {
    public final PodcastEpisodeRepository podcastEpisodeRepository;
    public final PodcastEpisodeConverter podcastEpisodeConverter;

    public List<PodcastEpisodeResponse> getPodcastEpisodeByIdArtist(Long artistsId) {
        List<PodcastEpisodeResponse> podcastResponse = new ArrayList<>();
        List<PodcastEpisode> podcasts = podcastEpisodeRepository.findByPodcasts_idAndActive(artistsId, true);
        for (PodcastEpisode podcast : podcasts) {
            podcastResponse.add(podcastEpisodeConverter.toResponse(podcast));
        }
        return podcastResponse;
    }
}
