package com.jestify.service;

import com.jestify.common.AppConstant;
import com.jestify.converter.PodcastConverter;
import com.jestify.entity.*;
import com.jestify.payload.*;
import com.jestify.repository.FollowRepository;
import com.jestify.repository.PodcastRepository;
import com.jestify.repository.UserRepository;
import com.jestify.utils.JsonUtil;
import com.jestify.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PodcastService {
    private final EpisodeService episodeService;
    private final PodcastRepository podcastRepository;

    private final UserRepository userRepository;
    private final PodcastConverter podcastConverter;
    private final FollowService followService;
    private final FollowRepository followRepository;

    public List<EpisodeResponse> getPodcastEpisode(Long podcastId) {
        return episodeService.getEpisodeByIdPodcast(podcastId);
    }

    public PodcastResponse getPodcastById(Long podcastId) {
        Podcasts podcasts = podcastRepository.findById(podcastId)
                .orElseThrow(() -> new IllegalStateException("Podcast not found"));
        Users user = userRepository.findById((podcasts.getUserId()))
                .orElseThrow(() -> new IllegalStateException("User not found"));
        Users userNowLogin = userRepository
                .findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElse(null);
        PodcastResponse podcastResponse = podcastConverter.toResponse(podcasts);
        if (userNowLogin != null) {
            Optional<Follows> follows = followRepository
                    .findByObjectIdAndTypeAndUserId(podcastId, AppConstant.PODCAST, userNowLogin.getId());
            follows.ifPresent(value -> podcastResponse.setFollowId(value.getId()));
        }
        podcastResponse.setEpisodeResponseList(getPodcastEpisode(podcastId));
        podcastResponse.setFullNameUser(user.getFullName());
        return podcastResponse;
    }


    public List<PodcastResponse> getFollowsPodcast(String type, Long userId) {
        List<FollowResponse> followResponseList = followService.getListFollows(userId, type);
        List<PodcastResponse> podcastResponseList = new ArrayList<>();
        for (FollowResponse followResponse : followResponseList) {
            Podcasts podcasts = podcastRepository.findById(followResponse.getObjectId()).orElseThrow(() -> new IllegalStateException("Not Found Podcast to Follow"));
            podcastResponseList.add(podcastConverter.toResponse(podcasts));
        }
        return podcastResponseList;
    }

    public PodcastResponse getPodcastInfo() {

        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently())
                .orElse(null);
        Podcasts podcasts = podcastRepository.findByUserId(users.getId())
                .orElseThrow(() -> new IllegalStateException("Artist not found"));
        PodcastResponse podcastResponse = podcastConverter.toResponse(podcasts);

        podcastResponse.setThumbnail(podcasts.getThumbnail());
        return podcastResponse;
    }
    @Transactional
    public void updateInfoPodcast(String podcastRequestJson, MultipartFile fileImg) {
        PodcastRequest podcastRequest = JsonUtil.toObject(podcastRequestJson, PodcastRequest.class);

        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElseThrow(() -> new IllegalStateException("Not Found User"));
        Podcasts podcasts = podcastRepository.findByUserId(users.getId()).orElse(null);


        if (fileImg != null) {
            podcasts.setThumbnail(podcastRequest.getAvatar());
        }
        podcasts.setName(podcastRequest.getNamePodcast());
        podcastRepository.save(podcasts);
    }

}
