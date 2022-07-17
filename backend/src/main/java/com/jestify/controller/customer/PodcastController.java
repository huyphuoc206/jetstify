package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.service.PodcastService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class PodcastController {
    private final PodcastService podcastService;
    @GetMapping
    public String getPodcast() {
        return "Podcasts";
    }

    @GetMapping("/podcastInfo")
    public ResponseEntity<?> getByPodcastInfo() {
        try {
            return ResponseEntity.ok(ResponseCommon.success(podcastService.getPodcastInfo()));
        }catch(IllegalStateException ex){
            log.error("API Error /api/podcastInfo - getByPodcastInfo", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));

        }catch (Exception ex){
            log.error("API Error /api/podcastInfo - getByPodcastInfo", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @PostMapping("/podcastInfo")
    public ResponseEntity<?> updateInfoPodcast(@RequestPart(value = "podcastRequest") String podcastRequest, @RequestPart(value = "fileImg", required = false) MultipartFile fileImg){
        try{
            podcastService.updateInfoPodcast(podcastRequest,fileImg);
            return ResponseEntity.ok(ResponseCommon.success(null));
        }catch (IllegalStateException ex){
            log.error("API Error api/podcastInfo/ - updateInfoArtist", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        }catch (Exception ex){
            log.error("API Error api/artistInfo/ - updateInfoArtist", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }


    @GetMapping("/public/podcast/{podcastId}/podcast_episode")
    public ResponseEntity<?> getPodcastEpisodeByArtistId(@PathVariable Long podcastId) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(podcastService.getPodcastEpisode(podcastId)));
        }catch (Exception ex){
            log.error("API Error /api/podcast/{podcastId}/podcasts - getPodcastEpisodeByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @GetMapping("/public/podcast/{podcastId}")
    public ResponseEntity<?> getByPodcastId(@PathVariable Long podcastId) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(podcastService.getPodcastById(podcastId)));
        }catch(IllegalStateException ex){
            log.error("API Error /api/podcast/{podcastId} - getByPodcastId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));

        }catch (Exception ex){
            log.error("API Error /api/podcast/{podcastId} - getByPodcastId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
