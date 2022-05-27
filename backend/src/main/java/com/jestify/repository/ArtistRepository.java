package com.jestify.repository;

import com.jestify.entity.Artists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artists,Long> {
}
