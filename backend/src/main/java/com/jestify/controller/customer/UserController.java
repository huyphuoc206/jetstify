package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.payload.FollowRequest;
import com.jestify.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            log.error("API Error /api/public/user/{artistId}/songs - getSongsByUserId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @PostMapping("/user/follows")
    public ResponseEntity<?> followObject(@RequestBody FollowRequest followRequest){
        try{
            return ResponseEntity.ok(ResponseCommon.success(userService.follow(followRequest)));
        }catch (IllegalStateException ex){
            log.error("API Error /api/user/follows - followObject", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        }catch (Exception ex){
            log.error("API Error /api/user/follows - followObject", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @GetMapping("/user/{userId}/followsPodcast")
    public ResponseEntity<?> getListFollowPodcast(@PathVariable Long userId){
        try{
            return ResponseEntity.ok(ResponseCommon.success(userService.getFollowsPodcast(userId)));
        }catch (IllegalStateException ex){
            log.error("API Error /api/user/{userId}/followsPodcast - getListFollowPodcast", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        }catch (Exception ex){
            log.error("API Error /api/user/{userId}/followsPodcast - getListFollowPodcast", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @GetMapping("/user/{userId}/followsArtist")
    public ResponseEntity<?> getListFollowArtist(@PathVariable Long userId){
        try{
            return ResponseEntity.ok(ResponseCommon.success(userService.getFollowsArtist(userId)));
        }catch (IllegalStateException ex){
            log.error("API Error api/user/{userId}/followsArtist - getListFollowArtist", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        }catch (Exception ex){
            log.error("API Error api/user/{userId}/followsArtist- getListFollowArtist", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
