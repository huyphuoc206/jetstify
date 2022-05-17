package com.jestify.repository;

import com.jestify.entity.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Songs, Long> {
    List<Songs> findByArtists_idAndActive(Long id, boolean active);
}
