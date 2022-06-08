package com.jestify.converter;

import com.jestify.entity.Users;
import com.jestify.payload.UserRequest;
import com.jestify.payload.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserResponse toResponse(Users entity){
        return UserResponse.builder()
                .avatar(entity.getAvatar())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .build();
    }
    public Users toEntity (UserRequest userRequest){
        return Users.builder()
                .avatar(userRequest.getAvatar())
                .fullName(userRequest.getFullName())
                .build();
    }
}
