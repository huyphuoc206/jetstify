package com.jestify.repository;

import com.jestify.entity.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Songs, Long> {
    List<Songs> findByUsers_idAndActive(Long id, boolean active);

    List<Songs> findByCategoryIdAndActive(Long id, boolean active);

    List<Songs> findByNameContainingIgnoreCaseAndActiveTrue(String name);

    @Query(value = "SELECT * FROM songs where active = true ORDER BY RANDOM() LIMIT 20", nativeQuery = true)
    List<Songs> findRandomSongs();

    @Query(value = "SELECT * FROM songs ORDER BY created_date DESC LIMIT 20", nativeQuery = true)
    List<Songs> findSongsNew();

    List<Songs> findByPlaylists_idAndActiveTrue(Long playlistId);
    @Query(value = "SELECT * FROM songs WHERE id = :songId AND ACTIVE = true", nativeQuery = true)
    Optional<Songs> findSongById(Long songId);

    @Query(value = "SELECT COUNT(*) FROM songs " +
            "WHERE songs.active = true " +
            "AND date_part('month', created_date) = :month " +
            "AND date_part('year', created_date) = :year", nativeQuery = true)
    long countSongsByMonthYear(int month, int year);
}
