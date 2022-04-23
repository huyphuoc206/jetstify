package com.web.project.converter;

import com.web.project.entity.Role;
import com.web.project.payload.RoleRequest;
import com.web.project.payload.RoleResponse;
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
