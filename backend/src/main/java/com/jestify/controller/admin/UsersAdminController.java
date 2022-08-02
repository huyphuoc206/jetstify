package com.jestify.controller.admin;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.payload.UserAdminRequest;
import com.jestify.service.UsersAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/admin/users")
public class UsersAdminController {
    private final UsersAdminService usersAdminService;

    @GetMapping
    public ResponseEntity<?> getUsers(@RequestParam("page") int page, @RequestParam int limit, @RequestParam(required = false, defaultValue = "") String email, @RequestParam(required = false) Boolean active) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(usersAdminService.getUsersPaging(page, limit, email, active)));
        } catch (Exception e) {
            log.error("API Error /api/admin/users - getUsers: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(usersAdminService.getUserById(id)));
        } catch (IllegalStateException e) {
            log.error("API Error /api/admin/users - getUserById: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API Error /api/admin/users - getUserById: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserAdminRequest request) {
        try {
            usersAdminService.updateUser(id, request);
            return ResponseEntity.ok(ResponseCommon.success(null));
        } catch (IllegalStateException e) {
            log.error("API Error /api/admin/users - updateUser: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API Error /api/admin/users - updateUser: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            usersAdminService.deleteUser(id);
            return ResponseEntity.ok(ResponseCommon.success(null));
        } catch (IllegalStateException e) {
            log.error("API Error /api/admin/users - deleteUser: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API Error /api/admin/users - deleteUser: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
