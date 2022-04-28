package com.jestify.service;

import com.jestify.converter.RoleConverter;
import com.jestify.payload.RoleRequest;
import com.jestify.payload.RoleResponse;
import com.jestify.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    private final RoleConverter roleConverter;

    public List<RoleResponse> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleConverter::toResponse)
                .collect(Collectors.toList());
    }

    public void addRole(RoleRequest request) {
        roleRepository.save(roleConverter.toEntity(request));
    }
}
