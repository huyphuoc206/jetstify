package com.jestify.controller.admin;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.service.CategoryService;
import com.jestify.service.DashboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/admin/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping("/users-chart")
    public ResponseEntity<?> searchUsersChart(@RequestParam String fromMonth, @RequestParam String toMonth) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(dashboardService.searchUsersChart(fromMonth, toMonth)));
        } catch (Exception e) {
            log.error("API Error /api/admin/dashboard/users-chart - searchUsersChart: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @GetMapping("/songs-chart")
    public ResponseEntity<?> searchSongsChart(@RequestParam(required = true) String fromMonth, @RequestParam(required = true) String toMonth) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(dashboardService.searchSongsChart(fromMonth, toMonth)));
        } catch (Exception e) {
            log.error("API Error /api/admin/dashboard/songs-chart - searchSongsChart: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
