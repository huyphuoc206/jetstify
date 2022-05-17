package com.jestify.controller.customer;

import com.jestify.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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



}
