package com.jestify.converter;

import com.jestify.entity.Users;
import com.jestify.payload.UserAdminResponse;
import com.jestify.payload.UserRequest;
import com.jestify.payload.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserAdminConverter {
    public UserAdminResponse toResponse(Users entity){
        return UserAdminResponse.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .email(entity.getEmail())
                .active(entity.isActive())
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getModifiedDate())
                .build();
    }
}
