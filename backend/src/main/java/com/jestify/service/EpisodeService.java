package com.jestify.service;

import com.jestify.converter.EpisodeConverter;
import com.jestify.entity.Episodes;
import com.jestify.payload.EpisodeRequest;
import com.jestify.payload.EpisodeResponse;
import com.jestify.repository.EpisodeRepository;
import com.jestify.utils.AmazonUtil;
import com.jestify.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {
    public final EpisodeRepository episodeRepository;
    public final EpisodeConverter episodeConverter;
    public final AmazonUtil amazonUtil;

    public List<EpisodeResponse> getEpisodeByIdPodcast(Long podcastId) {
        List<EpisodeResponse> podcastResponse = new ArrayList<>();
        List<Episodes> podcasts = episodeRepository.findByPodcasts_idAndActive(podcastId, true);
        for (Episodes podcast : podcasts) {
            podcastResponse.add(episodeConverter.toResponse(podcast));
        }
        return podcastResponse;
    }
    public EpisodeResponse createEpisode(MultipartFile fileEpisode, MultipartFile fileJpg, String jsonEpisode){
        EpisodeRequest episodeRequest = JsonUtil.toObject(jsonEpisode, EpisodeRequest.class);
        Episodes episodes = episodeConverter.toEntity(episodeRequest);
        episodes.setActive(true);
        episodes.setDescription(episodeRequest.getDescription());
        episodes.setLink(amazonUtil.uploadFile(fileEpisode));
        episodes.setThumbnail(amazonUtil.uploadFile(fileJpg));
        episodes.setName(episodeRequest.getName());
        episodeRepository.save(episodes);
        return episodeConverter.toResponse(episodes);
    }
    public void updateEpisode(Long episodeId,MultipartFile fileEpisode, MultipartFile fileJpg, String jsonEpisode){
        EpisodeRequest episodeRequest = JsonUtil.toObject(jsonEpisode, EpisodeRequest.class);
        Episodes episodes = episodeRepository.findById(episodeId).orElse(null);
        episodes.setDescription(episodeRequest.getDescription());
        episodes.setLink(amazonUtil.uploadFile(fileEpisode));
        episodes.setThumbnail(amazonUtil.uploadFile(fileJpg));
        episodes.setName(episodeRequest.getName());
        episodeRepository.save(episodes);

    }
    public void deleteEpisode(Long episodeId){
        Episodes episodes = episodeRepository.findById(episodeId).orElse(null);
        episodes.setActive(false);
        episodeRepository.save(episodes);

    }
}
