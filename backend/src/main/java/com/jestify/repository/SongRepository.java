package com.jestify.repository;

import com.jestify.entity.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Songs, Long> {
    List<Songs> findByUsers_idAndActive(Long id, boolean active);

    List<Songs> findByCategoryIdAndActive(Long id, boolean active);

    List<Songs> findByNameContainingIgnoreCaseAndActiveTrue(String name);

    @Query(value = "SELECT * FROM songs where active = true ORDER BY RANDOM() LIMIT 20", nativeQuery = true)
    List<Songs> findRandomSongs();

    @Query(value = "SELECT * FROM songs ORDER BY created_date DESC LIMIT 20", nativeQuery = true)
    List<Songs> findSongsNew();

}
