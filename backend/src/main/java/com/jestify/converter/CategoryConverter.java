package com.jestify.converter;

import com.jestify.entity.Category;
import com.jestify.payload.CategoryRequest;
import com.jestify.payload.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryResponse toResponse(Category entity) {
        return CategoryResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getModifiedDate())
                .build();
    }

    public Category toEntity(CategoryRequest request) {
        return Category.builder()
                .code(request.getCode())
                .name(request.getName())
                .active(true)
                .build();
    }
}
