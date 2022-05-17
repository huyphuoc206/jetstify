package com.jestify.repository;

import com.jestify.entity.Podcasts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PodcastRepository extends JpaRepository<Podcasts, Long> {
    List<Podcasts> findByArtists_idAndActive(Long id, boolean active);
}
