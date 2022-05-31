package com.jestify.repository;

import com.jestify.entity.Podcasts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastRepository extends JpaRepository<Podcasts, Long> {
}
