package com.jestify.repository;

import com.jestify.entity.Follows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follows, Long> {
   List<Follows> findByTypeAndUserId(String type, Long userId);
}
