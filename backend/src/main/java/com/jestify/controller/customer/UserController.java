package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.payload.FollowRequest;
import com.jestify.payload.UserRequest;
import com.jestify.service.FollowService;
import com.jestify.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final FollowService followService;

    @GetMapping("/public/user/{userId}/songs")
    public ResponseEntity<?> getSongsByUserId(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(userService.getSongs(userId)));
        } catch (Exception ex) {
            log.error("API Error /api/public/user/{artistId}/songs - getSongsByUserId", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @PostMapping("/user/follows")
    public ResponseEntity<?> followObject(@RequestBody FollowRequest followRequest) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(userService.follow(followRequest)));
        } catch (IllegalStateException ex) {
            log.error("API Error /api/user/follows - followObject", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        } catch (Exception ex) {
            log.error("API Error /api/user/follows - followObject", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @GetMapping("/user/follow")
    public ResponseEntity<?> getListFollow(@RequestParam String type) {
        try {
            switch (type) {
                case AppConstant.ARTIST: {
                    return ResponseEntity.ok(ResponseCommon.success(userService.getFollowsArtist(type)));
                }
                case AppConstant.PODCAST: {
                    return ResponseEntity.ok(ResponseCommon.success(userService.getFollowsPodcast(type)));
                }
                default: {
                    return ResponseEntity.ok(ResponseCommon.fail("Not Found"));
                }
            }
        } catch (IllegalStateException ex) {
            log.error("API Error api/user/follow - getListFollow", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        } catch (Exception ex) {
            log.error("API Error api/user/follow- getListFollow", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @DeleteMapping("/user/follow/{followId}")
    public ResponseEntity<?> unFollowArtist(@PathVariable Long followId) {
        try {
            followService.unFollow(followId);
            return ResponseEntity.ok(ResponseCommon.success(null));
        } catch (IllegalStateException ex) {
            log.error("API Error api/user/follow - unFollow", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        } catch (Exception ex) {
            log.error("API Error api/user/follow- unFollow", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @GetMapping("/user")
    public ResponseEntity<?> getInfoUser(){
        try{
            return ResponseEntity.ok(ResponseCommon.success(userService.getInfoUser()));
        }catch (IllegalStateException ex){
            log.error("API Error api/user/ - getInfoUser", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        }catch (Exception ex){
            log.error("API Error api/user/ - getInfoUser", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @PostMapping("/user")
    public ResponseEntity<?> updateInfoUser(@RequestPart(value = "userRequest") String userRequest, @RequestPart(value = "fileImg")MultipartFile fileImg){
        try{
            userService.updateInfoUser(userRequest,fileImg);
            return ResponseEntity.ok(ResponseCommon.success(null));
        }catch (IllegalStateException ex){
            log.error("API Error api/user/ - updateInfoUser", ex);
            return ResponseEntity.ok(ResponseCommon.fail(ex.getMessage()));
        }catch (Exception ex){
            log.error("API Error api/user/ - updateInfoUser", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
