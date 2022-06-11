package com.jestify.repository;

import com.jestify.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmailAndActiveTrueAndRolesCode(String username, String role);
    Optional<Users> findByEmailAndActiveTrue(String email);
    Optional<Users> findByEmail(String email);

    Optional<Users> findByKey(String key);
}