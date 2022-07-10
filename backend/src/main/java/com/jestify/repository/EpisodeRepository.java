package com.jestify.repository;

import com.jestify.entity.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episodes, Long> {
    List<Episodes> findByPodcasts_idAndActive(Long id, boolean active);
}
