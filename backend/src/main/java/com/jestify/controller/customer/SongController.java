package com.jestify.controller.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SongController {

    @GetMapping("/song")
    public String getSong() {
        return "Song";
    }
}
