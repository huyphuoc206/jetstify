package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @GetMapping("/public/user/{userId}/songs")
    public ResponseEntity<?> getSongsByUserId(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(userService.getSongs(userId)));
        }catch (Exception ex){
            log.error("API Error /api/user/{artistId}/songs - getSongsByUserId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
