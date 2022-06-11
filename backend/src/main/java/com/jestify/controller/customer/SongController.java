package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.payload.SongRequest;
import com.jestify.utils.AmazoneUtil;
import com.jestify.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping()
    public ResponseEntity<?> creatSong(@RequestParam(value = "file") MultipartFile file, @RequestParam SongRequest songRequest) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(songService.uploadSongs(songRequest, file)));
        } catch (Exception ex) {
            log.error("API Error /api/song - creatSong", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

}
