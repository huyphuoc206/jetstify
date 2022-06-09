package com.jestify.service;

import com.jestify.converter.CategoryConverter;
import com.jestify.entity.Category;
import com.jestify.payload.CategoryRequest;
import com.jestify.payload.CategoryResponse;
import com.jestify.payload.SongResponse;
import com.jestify.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryConverter categoryConverter;
    private final CategoryRepository categoryRepository;
    private final SongService songService;

    public List<CategoryResponse> getCategories() {
        return categoryRepository.findByActiveTrue()
                .stream().map(categoryConverter::toResponse)
                .collect(Collectors.toList());
    }

    public CategoryResponse getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryConverter::toResponse)
                .orElseThrow(() -> new IllegalStateException("Category not found"));
    }

    public CategoryResponse createCategory(CategoryRequest request) {
        boolean existCategoryCode = categoryRepository.findByCode(request.getCode()).isPresent();
        if (existCategoryCode) {
            throw new IllegalStateException("Category code is duplicated");
        }
        Category entity = categoryRepository.save(categoryConverter.toEntity(request));
        return categoryConverter.toResponse(entity);
    }

    public void updateCategory(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category not found"));
        Optional<Category> categoryByCode = categoryRepository.findByCode(request.getCode());
        if (categoryByCode.isPresent() && !Objects.equals(categoryByCode.get().getId(), id)) {
            throw new IllegalStateException("Category code is duplicated");
        }
        category.setName(request.getName());
        category.setCode(request.getCode());
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Category not found"));
        category.setActive(false);
        categoryRepository.save(category);
    }

    public List<SongResponse> getSongByCategoryId(Long categoryId) {
        return songService.getSongsByCategoryId(categoryId);
    }
}
