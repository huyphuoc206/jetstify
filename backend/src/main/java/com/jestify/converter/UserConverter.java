package com.jestify.converter;

import com.jestify.payload.UserRequest;
import com.jestify.payload.UserResponse;
import com.jestify.entity.Role;
import com.jestify.entity.Users;
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
