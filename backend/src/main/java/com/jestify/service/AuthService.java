package com.jestify.service;

import com.jestify.common.AppConstant;
import com.jestify.repository.UserRepository;
import com.jestify.payload.AuthRequest;
import com.jestify.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    public Users checkLoginCustomer(AuthRequest loginRequest) {
        Users user = userRepository.findByEmailAndActiveTrueAndRoleCode(loginRequest.getEmail(), AppConstant.CUSTOMER_ROLE)
                .orElseThrow(() -> new IllegalArgumentException("Email or password is incorrect"));
        // Compare raw password and password in database
//        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
        if (loginRequest.getPassword().equals(user.getPassword())) {
            return user;
        } else {
            throw new IllegalArgumentException("Email or password is incorrect");
        }
    }

    public Users checkLoginAdmin(AuthRequest loginRequest) {
        Users user = userRepository.findByEmailAndActiveTrueAndRoleCode(loginRequest.getEmail(), AppConstant.ADMIN_ROLE)
                .orElseThrow(() -> new IllegalArgumentException("Email or password is incorrect"));
        // Compare raw password and password in database
//        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
        if (loginRequest.getPassword().equals(user.getPassword())) {
            return user;
        } else {
            throw new IllegalArgumentException("Email or password is incorrect");
        }
    }
}
