package com.jestify.repository;

import com.jestify.entity.Playlists;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlists, Long> {
    List<Playlists> findByCreatedBy(String email);
}
