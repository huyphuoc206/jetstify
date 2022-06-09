package com.jestify.controller.admin;

import com.jestify.common.AppConstant;
import com.jestify.common.ResponseCommon;
import com.jestify.payload.CategoryRequest;
import com.jestify.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/admin/category")
public class CategoryAdminController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getCategories() {
        try {
            return ResponseEntity.ok(ResponseCommon.success(categoryService.getCategories()));
        } catch (Exception e) {
            log.error("API Error /api/admin/category - getCategories: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(categoryService.getCategoryById(id)));
        } catch (IllegalStateException e) {
            log.error("API Error /api/admin/category - getCategoryById: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(e.getMessage()));
        }  catch (Exception e) {
            log.error("API Error /api/admin/category - getCategoryById: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest request) {
        try {
            return ResponseEntity.ok(ResponseCommon.success(categoryService.createCategory(request)));
        } catch (IllegalStateException e) {
            log.error("API Error /api/admin/category - createCategory: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API Error /api/admin/category - createCategory: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request) {
        try {
            categoryService.updateCategory(id, request);
            return ResponseEntity.ok(ResponseCommon.success(null));
        } catch (IllegalStateException e) {
            log.error("API Error /api/admin/category - updateCategory: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API Error /api/admin/category - updateCategory: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok(ResponseCommon.success(null));
        } catch (IllegalStateException e) {
            log.error("API Error /api/admin/category - deleteCategory: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(e.getMessage()));
        } catch (Exception e) {
            log.error("API Error /api/admin/category - deleteCategory: ", e);
            return ResponseEntity.ok(ResponseCommon.fail(AppConstant.ERROR_MESSAGE));
        }
    }
}
