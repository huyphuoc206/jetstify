package com.web.project.modules.role.converter;

import com.web.project.modules.role.entity.Role;
import com.web.project.modules.role.payload.RoleRequest;
import com.web.project.modules.role.payload.RoleResponse;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class RoleConverter {

    public RoleResponse toResponse(Role entity) {
        return RoleResponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdDate(entity.getCreatedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .build();
    }

    public Role toEntity(RoleRequest request) {
        return Role.builder()
                .name(request.getName())
                .code(request.getCode())
                .build();
    }
}
