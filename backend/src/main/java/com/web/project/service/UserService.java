package com.web.project.service;

import com.web.project.repository.RoleRepository;
import com.web.project.converter.UserConverter;
import com.web.project.payload.UserRequest;
import com.web.project.payload.UserResponse;
import com.web.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserConverter userConverter;

    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userConverter::toResponse)
                .collect(Collectors.toList());
    }

    public void addUser(UserRequest request) {
        request.setRoles(request.getRoleIds()
                .stream()
                .map(e -> roleRepository.findById(e).get())
                .collect(Collectors.toList()));
        request.setActive(true);
        userRepository.save(userConverter.toEntity(request));
    }
}
