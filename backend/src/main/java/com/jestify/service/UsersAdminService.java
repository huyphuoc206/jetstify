package com.jestify.service;

import com.jestify.common.AppConstant;
import com.jestify.converter.UserAdminConverter;
import com.jestify.entity.Users;
import com.jestify.payload.UserAdminRequest;
import com.jestify.payload.UserAdminResponse;
import com.jestify.payload.UsersAdminPagingResponse;
import com.jestify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersAdminService {
    private final UserRepository userRepository;
    private final UserAdminConverter userAdminConverter;

    public void deleteUser(Long id) {
        Users user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
        user.setActive(false);
        userRepository.save(user);
    }

    public void updateUser(Long id, UserAdminRequest request) {
        Users user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
        user.setFullName(request.getFullName());
        user.setActive(request.isActive());
        userRepository.save(user);
    }

    public UserAdminResponse getUserById(Long id) {
        return userRepository.findById(id)
                .map(userAdminConverter::toResponse)
                .orElseThrow(() -> new IllegalStateException("User not found"));
    }

    public UsersAdminPagingResponse getUsersPaging(int page, int limit, String email, Boolean active) {
        if (email == null) {
            email = "";
        }
        if (active == null) {
            active = true;
        }
        Pageable pageRequest = PageRequest.of(page - 1, limit);
        List<UserAdminResponse> userAdminResponses = userRepository.findByEmailContainingIgnoreCaseAndActiveAndRolesCode(pageRequest, email, active, AppConstant.CUSTOMER_ROLE)
                .stream().map(userAdminConverter::toResponse)
                .collect(Collectors.toList());
        long totalItems = userRepository.countByEmailContainingIgnoreCaseAndActiveAndRolesCode(email, active, AppConstant.CUSTOMER_ROLE);
        return UsersAdminPagingResponse.builder().users(userAdminResponses).totalItems(totalItems).build();
    }
}
