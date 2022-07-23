package com.jestify.repository;

import com.jestify.entity.ArtistPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistPhotoRepository extends JpaRepository<ArtistPhoto, Long> {
    List<ArtistPhoto> findByArtists_idAndActive(Long artistId, boolean active);
}
