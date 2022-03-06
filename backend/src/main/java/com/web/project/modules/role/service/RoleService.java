package com.web.project.modules.role.service;

import com.web.project.modules.role.converter.RoleConverter;
import com.web.project.modules.role.payload.RoleRequest;
import com.web.project.modules.role.payload.RoleResponse;
import com.web.project.modules.role.repository.RoleRepository;
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
