package com.jestify.service;

import com.jestify.converter.CategoryConverter;
import com.jestify.entity.Category;
import com.jestify.payload.CategoryRequest;
import com.jestify.payload.CategoryResponse;
import com.jestify.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryConverter categoryConverter;
    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getCategories() {
        return categoryRepository.findByActiveTrue()
                .stream().map(categoryConverter::toResponse)
                .collect(Collectors.toList());
    }

    public void createCategory(CategoryRequest request) {
        categoryRepository.save(categoryConverter.toEntity(request));
    }

    public void updateCategory(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category not found"));
        category.setName(request.getName());
        category.setCode(request.getCode());
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category not found"));
        category.setActive(false);
        categoryRepository.save(category);
    }
}
