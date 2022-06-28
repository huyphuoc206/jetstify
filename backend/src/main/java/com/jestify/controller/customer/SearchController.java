package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/public/search")
public class SearchController {
    private final SearchService searchService;
    @GetMapping
    public ResponseEntity<?> getSearch(@RequestParam String name) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(searchService.searchResponses(name)));
        }catch (Exception ex){
            log.error("API Error /api/podcast/{podcastId}/podcasts - getPodcastEpisodeByArtistId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
