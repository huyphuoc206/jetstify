package com.jestify.repository;

import com.jestify.entity.Songs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Songs, Long> {
    List<Songs> findByUsers_idAndActive(Long id, boolean active);
    List<Songs> findByCategoryIdAndActive(Long id, boolean active);
    List<Songs> findByNameContainingIgnoreCaseAndActiveTrue(String name);
}
