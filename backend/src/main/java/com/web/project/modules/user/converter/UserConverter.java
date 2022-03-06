package com.web.project.modules.user.converter;

import com.web.project.modules.role.entity.Role;
import com.web.project.modules.user.entity.Users;
import com.web.project.modules.user.payload.UserRequest;
import com.web.project.modules.user.payload.UserResponse;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserConverter {

    public UserResponse toResponse(Users entity) {
        return UserResponse
                .builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .fullName(entity.getFullName())
                .roles(entity.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                .build();
    }

    public Users toEntity(UserRequest request) {
        return Users.builder()
                .username(request.getUsername())
                .fullName(request.getFullName())
                .password(request.getPassword())
                .roles(request.getRoles())
                .active(request.isActive())
                .build();
    }
}
