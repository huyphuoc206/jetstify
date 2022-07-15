package com.jestify.controller.customer;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.payload.CategoryRequest;
import com.jestify.payload.PlaylistRequest;
import com.jestify.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class PlaylistController {
    private final PlaylistService playlistService;

    @GetMapping("/playlist")
    public ResponseEntity<?> getPlayListUserPresent(){
        try {
            return ResponseEntity.ok(ResponseCommon.success(playlistService.getListPlaylistByUserPresent()));
        }catch (Exception ex){
            log.error("API Error /api/playlist- getPlayListUserPresent", ex);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @PostMapping("/playlist")
    public ResponseEntity<?> createPlaylist(){
        try {
            return ResponseEntity.ok(ResponseCommon.success(playlistService.createPlaylist()));
        } catch (IllegalStateException e) {
            log.error("API Error /api/playlist - createPlaylist: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API Error /api/playlist - createPlaylist: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @PutMapping("/playlist/{playlistId}")
    public ResponseEntity<?> updatePlaylist(@PathVariable Long playlistId, @RequestBody PlaylistRequest request){
        try {
            playlistService.updatePlaylist(playlistId,request);
            return ResponseEntity.ok(ResponseCommon.success(null));
        } catch (IllegalStateException e) {
            log.error("API Error /api/playlist/{playlistId} - updatePlaylist: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API Error /api/playlist/{playlistId}- updatePlaylist: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
    @DeleteMapping("/playlist/{playlistId}")
    public ResponseEntity<?> deletePlaylist(@PathVariable Long playlistId){
        try {
            playlistService.deletePlaylist(playlistId);
            return ResponseEntity.ok(ResponseCommon.success(null));
        } catch (IllegalStateException e) {
            log.error("API Error /api/playlist/{playlistId} - deletePlaylist: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API Error /api/playlist/{playlistId}- deletePlaylist: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
