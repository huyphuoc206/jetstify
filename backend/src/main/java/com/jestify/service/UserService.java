package com.jestify.service;

import com.jestify.repository.RoleRepository;
import com.jestify.converter.UserConverter;
import com.jestify.payload.UserRequest;
import com.jestify.payload.UserResponse;
import com.jestify.repository.UserRepository;
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
