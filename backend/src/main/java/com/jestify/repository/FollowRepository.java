package com.jestify.repository;

import com.jestify.entity.Follows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface FollowRepository extends JpaRepository<Follows, Long> {
    Optional<Follows> findByType(String type);
    List<Follows> findByUserId(Long userId);
}
