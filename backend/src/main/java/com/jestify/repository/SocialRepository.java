package com.jestify.repository;

import com.jestify.entity.Socials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialRepository extends JpaRepository<Socials, Long> {
     List<Socials> findByArtists_idAndActive(Long artistId, boolean active);
}
