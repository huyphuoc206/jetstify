package com.jestify.service;

import com.jestify.converter.PodcastConverter;
import com.jestify.entity.Podcasts;
import com.jestify.payload.PodcastResponse;
import com.jestify.repository.PodcastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PodcastService {
    public final PodcastRepository podcastRepository;
    public final PodcastConverter podcastConverter;

    public List<PodcastResponse> getPodcastsByIdArtist(Long artistsId) {
        List<PodcastResponse> podcastResponses = new ArrayList<>();
        List<Podcasts> podcasts = podcastRepository.findByArtists_idAndActive(artistsId, true);
        for (Podcasts podcast : podcasts) {
            podcastResponses.add(podcastConverter.toResponse(podcast));
        }
        return podcastResponses;
    }
}
