package com.web.project.modules.user.repository;

import com.web.project.modules.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsernameAndActive(String username, boolean active);
}
