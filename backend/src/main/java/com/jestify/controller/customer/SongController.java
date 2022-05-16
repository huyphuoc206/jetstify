package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
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
@RequestMapping("/api/song")
public class SongController {
    private final SongService songService;

    @GetMapping
    public String getSong() {
        return "Song";
    }


    @GetMapping("/{artistId}")
    public ResponseEntity<?> getSongById(@PathVariable Long artistId) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(songService.getAllById(artistId)));
        } catch (IllegalArgumentException ex) {
            log.error("API Error /api/songs - getSongById", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        }catch (Exception ex){
            log.error("Api/songs", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
