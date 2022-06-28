package com.jestify.repository;

import com.jestify.entity.Artists;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artists,Long> {
    List<Artists> findByNickNameContainingIgnoreCaseAndVerifyTrue( String nickName);
}
