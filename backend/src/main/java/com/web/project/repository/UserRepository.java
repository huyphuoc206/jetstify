package com.web.project.repository;

import com.web.project.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsernameAndActive(String username, boolean active);
}
