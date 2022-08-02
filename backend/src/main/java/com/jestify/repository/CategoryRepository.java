package com.jestify.repository;

import com.jestify.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameContainingIgnoreCaseAndActiveTrue(Pageable pageable, String name);
    long countByNameContainingIgnoreCaseAndActiveTrue(String name);
    List<Category> findByActiveTrue();

    Optional<Category> findByCode(String code);
}
