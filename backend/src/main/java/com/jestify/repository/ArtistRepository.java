package com.jestify.repository;

import com.jestify.entity.Artists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artists, Long> {
    List<Artists> findByNickNameContainingIgnoreCaseAndVerifyTrue(String nickName);

    @Query(value = "SELECT * FROM artists where verify = true ORDER BY RANDOM() LIMIT 20", nativeQuery = true)
    List<Artists> findRandomArtists();
}
