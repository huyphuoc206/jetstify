package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.service.ArtistService;
import com.jestify.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/artist")
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping("/{artistId}/songs")
    public ResponseEntity<?> getSongsByArtistId(@PathVariable Long artistId) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(artistService.getSongs(artistId)));
        }catch (Exception ex){
            log.error("API Error /api/artist/{artistId}/songs - getSongsByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @GetMapping("/{artistId}/podcasts")
    public ResponseEntity<?> getPodcastsByArtistId(@PathVariable Long artistId) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(artistService.getPodcasts(artistId)));
        }catch (Exception ex){
            log.error("API Error /api/artist/{artistId}/podcasts - getPodcastsByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @GetMapping("/{artistId}/socials")
    public ResponseEntity<?> getSocialsByArtistId(@PathVariable Long artistId){
        try {
            return ResponseEntity.ok(ResponseCommon.success(artistService.getSocials(artistId)));
        }catch (Exception ex){
            log.error("API Error /api/artist/{artistId}/socials - getSocialsByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @GetMapping("/{artistId}")
    public ResponseEntity<?> getByArtistId(@PathVariable Long artistId) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(artistService.getArtistById(artistId)));
        }catch(IllegalStateException ex){
            log.error("API Error /api/artist/{artistId} - getByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));

        }catch (Exception ex){
            log.error("API Error /api/artist/{artistId} - getByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @GetMapping("/{artistId}/images")
    public ResponseEntity<?> getImagesByArtistId(@PathVariable Long artistId){
        try {
            return ResponseEntity.ok(ResponseCommon.success(artistService.getImages(artistId)));
        }catch (Exception ex){
            log.error("API Error /api/artist/{artistId}/images - getImagesByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
