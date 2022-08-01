package com.jestify.repository;

import com.jestify.entity.Category;
import com.jestify.entity.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmailAndActiveTrueAndRolesCode(String username, String role);

    Optional<Users> findByEmailAndRolesCode(String username, String role);

    Optional<Users> findByEmailAndActiveTrue(String email);

    Optional<Users> findByEmail(String email);

    Optional<Users> findByKey(String key);

    List<Users> findByEmailContainingIgnoreCaseAndActiveAndRolesCode(Pageable pageRequest, String email, boolean active, String role);

    long countByEmailContainingIgnoreCaseAndActiveAndRolesCode(String email, boolean active, String role);

    @Query(value = "SELECT COUNT(*) FROM users join roles on users.role_id = roles.id " +
            "WHERE users.active = true " +
            "AND date_part('month', users.created_date) = :month " +
            "AND date_part('year', users.created_date) = :year " +
            "AND roles.code = :role", nativeQuery = true)
    long countActiveUsersByMonthYearRole(int month, int year, String role);
}