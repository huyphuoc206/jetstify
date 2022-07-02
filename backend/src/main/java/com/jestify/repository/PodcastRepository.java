package com.jestify.repository;

import com.jestify.entity.Podcasts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PodcastRepository extends JpaRepository<Podcasts, Long> {
    List<Podcasts> findByNameContainingIgnoreCaseAndActiveTrue(String name);

    @Query(value = "SELECT * FROM podcasts where active = true ORDER BY RANDOM() LIMIT 20", nativeQuery = true)
    List<Podcasts> findRandomPodcasts();

    @Query(value = "SELECT * FROM podcasts ORDER BY created_date DESC LIMIT 20", nativeQuery = true)
    List<Podcasts> findPodcastsNew();

}
