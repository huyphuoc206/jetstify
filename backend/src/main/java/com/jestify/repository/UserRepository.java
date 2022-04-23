package com.jestify.repository;

import com.jestify.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsernameAndActive(String username, boolean active);
}
