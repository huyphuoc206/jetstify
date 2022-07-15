package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/episode")
public class EpisodeController {
    private final EpisodeService episodeService;

    @PostMapping
    public ResponseEntity<?> creatEpisode(@RequestPart(value = "fileMp3") MultipartFile fileEpisode,
                                          @RequestPart(value = "fileImg") MultipartFile fileImg,
                                          @RequestPart(value = "episodeRequest") String episodeRequest) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(episodeService.createEpisode(fileEpisode, fileImg, episodeRequest)));
        } catch (Exception ex) {
            log.error("API Error /api/episode - creatEpisode", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @PutMapping("/{episodeId}")
    public ResponseEntity<?> updateEpisode(@PathVariable Long episodeId,
                                           @RequestPart(value = "fileMp3") MultipartFile fileEpisode,
                                           @RequestPart(value = "fileImg") MultipartFile fileImg,
                                           @RequestPart(value = "episodeRequest") String episodeRequest) {
        try {
            episodeService.updateEpisode(episodeId, fileEpisode, fileImg, episodeRequest);
            return ResponseEntity.ok(ResponseCommon.success(null));
        } catch (Exception ex) {
            log.error("API Error /api/episode/{episodeId} - updateEpisode", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @DeleteMapping("/{episodeId}")
    public ResponseEntity<?> deleteEpisode(@PathVariable Long episodeId) {
        try {
            episodeService.deleteEpisode(episodeId);
            return ResponseEntity.ok(ResponseCommon.success(null));
        } catch (Exception ex) {
            log.error("API Error /api/episode/{episodeId} - deleteEpisode", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
