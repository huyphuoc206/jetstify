package com.jestify.service;

import com.jestify.common.AppConstant;
import com.jestify.converter.PodcastConverter;
import com.jestify.entity.Podcasts;
import com.jestify.entity.Users;
import com.jestify.payload.EpisodeResponse;
import com.jestify.payload.FollowResponse;
import com.jestify.payload.PodcastResponse;
import com.jestify.repository.PodcastRepository;
import com.jestify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PodcastService {
    private final EpisodeService episodeService;
    private final PodcastRepository podcastRepository;
    private final PodcastConverter podcastConverter;
    private final FollowService followService;
    private final UserService userService;
    private final UserRepository userRepository;

    public List<EpisodeResponse> getPodcastEpisode(Long podcastId) {
        return episodeService.getEpisodeByIdPodcast(podcastId);
    }

    public PodcastResponse getPodcastById(Long podcastId) {
        Podcasts podcasts = podcastRepository.findById(podcastId)
                .orElseThrow(() -> new IllegalStateException("Artist not found"));
        PodcastResponse podcastResponse = podcastConverter.toResponse(podcasts);
        return podcastResponse;
    }

    public List<PodcastResponse> getFollowsPodcast(String type) {
        Users users = userRepository.findByEmailAndActiveTrue(userService.checkUserCurrently()).orElseThrow(()-> new IllegalStateException("User not found"));
        List<FollowResponse> followResponseList = followService.getListFollows(users.getId(),type);
        List<PodcastResponse> podcastResponseList = new ArrayList<>();
        for (FollowResponse followResponse : followResponseList) {
            Podcasts podcasts = podcastRepository.findById(followResponse.getObjectId()).orElseThrow(() -> new IllegalArgumentException("Not Found Podcast to Follow"));
            podcastResponseList.add(podcastConverter.toResponse(podcasts));
        }
        return podcastResponseList;
    }
}
