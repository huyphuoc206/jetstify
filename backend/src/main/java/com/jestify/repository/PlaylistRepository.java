package com.jestify.repository;

import com.jestify.entity.Playlists;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlists, Long> {
    List<Playlists> findByCreatedByAndActiveTrueOrderByIdDesc(String email);
    Optional<Playlists> findByIdAndActiveTrue(Long id);
}
