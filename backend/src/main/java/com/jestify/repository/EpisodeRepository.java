package com.jestify.repository;

import com.jestify.entity.PodcastEpisode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PodcastEpisodeRepository extends JpaRepository<PodcastEpisode, Long> {
    List<PodcastEpisode> findByPodcasts_idAndActive(Long id, boolean active);
}
