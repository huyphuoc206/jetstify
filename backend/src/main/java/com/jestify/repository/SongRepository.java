package com.jestify.repository;

import com.jestify.entity.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Songs, Long> {
    List<Songs> findByUsers_idAndActive(Long id, boolean active);
    List<Songs> findByCategoryIdAndActive(Long id, boolean active);
}
