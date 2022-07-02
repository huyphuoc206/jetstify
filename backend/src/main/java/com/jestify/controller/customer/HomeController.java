package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.service.HomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/public/home")
public class HomeController {
    private final HomeService homeService;
    @GetMapping
    public ResponseEntity<?> getHomeData(){
        try {
            return ResponseEntity.ok(ResponseCommon.success(homeService.getDataHome()));
        }catch (Exception ex){
            log.error("API Error /api/public/home - getHomeData", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
