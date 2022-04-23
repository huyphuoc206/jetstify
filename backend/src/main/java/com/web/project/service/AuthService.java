package com.web.project.service;

import com.web.project.payload.AuthRequest;
import com.web.project.entity.Users;
import com.web.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    public Users checkLogin(AuthRequest loginRequest) {
        Users user = userRepository.findByUsernameAndActive(loginRequest.getUsername(), true);
        if (user == null) {
            return null;
        }
        // Compare raw password and password in database
//        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
        if (loginRequest.getPassword().equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
