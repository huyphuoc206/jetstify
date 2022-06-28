package com.jestify.repository;

import com.jestify.entity.Podcasts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PodcastRepository extends JpaRepository<Podcasts, Long> {
    List<Podcasts> findByNameContainingIgnoreCaseAndActiveTrue(String name);
}
