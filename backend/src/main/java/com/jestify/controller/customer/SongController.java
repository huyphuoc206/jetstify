package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping
    public ResponseEntity<?> creatSong(@RequestPart(value = "fileMp3") MultipartFile fileMp3,
                                       @RequestPart(value = "fileImg") MultipartFile fileImg,
                                       @RequestPart(value = "songRequest") String songRequest) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(songService.uploadSongs( fileMp3,fileImg,songRequest)));
        } catch (Exception ex) {
            log.error("API Error /api/song - creatSong", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

}
