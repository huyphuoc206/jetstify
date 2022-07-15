package com.jestify.repository;

import com.jestify.entity.Follows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follows, Long> {
    List<Follows> findByTypeAndUserId(String type, Long userId);

    Optional<Follows> findByObjectIdAndTypeAndUserId(Long objectId, String type, Long userId);

    @Query(value = "SELECT OBJECT_ID \n" +
            "FROM (\n" +
            "SELECT OBJECT_ID, COUNT(*) FROM follows WHERE type = :type GROUP BY OBJECT_ID ORDER BY COUNT DESC) K LIMIT 20", nativeQuery = true)
    List<Long> findByFollowers(@Param("type") String type);
}
