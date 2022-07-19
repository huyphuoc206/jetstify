package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping("/artistInfo")
    public ResponseEntity<?> getByArtistInfo() {
        try {
            return ResponseEntity.ok(ResponseCommon.success(artistService.getArtistInfo()));
        }catch(IllegalStateException ex){
            log.error("API Error /api/artist/{artistId} - getByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));

        }catch (Exception ex){
            log.error("API Error /api/artist/{artistId} - getByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @PostMapping("/artistInfo")
    public ResponseEntity<?> updateInfoArtist(@RequestPart(value = "artistRequest") String artistRequest, @RequestPart(value = "fileImg", required = false) MultipartFile fileImg){
        try{
            artistService.updateInfoArtist(artistRequest,fileImg);
            return ResponseEntity.ok(ResponseCommon.success(null));
        }catch (IllegalStateException ex){
            log.error("API Error api/artistInfo/ - updateInfoArtist", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        }catch (Exception ex){
            log.error("API Error api/artistInfo/ - updateInfoArtist", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @GetMapping("/public/artist/{artistId}")
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
    @GetMapping("/public/artist/{artistId}/photos")
    public ResponseEntity<?> getPhotosByArtistId(@PathVariable Long artistId){
        try {
            return ResponseEntity.ok(ResponseCommon.success(artistService.getPhotos(artistId)));
        }catch (Exception ex){
            log.error("API Error /api/artist/{artistId}/photos - getPhotosByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @GetMapping("/public/artist/{userId}/songs")
    public ResponseEntity<?> getSongsByArtistId(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(artistService.getSongs(userId)));
        }catch (Exception ex){
            log.error("API Error /api/artist/{artistId}/songs - getSongsByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
