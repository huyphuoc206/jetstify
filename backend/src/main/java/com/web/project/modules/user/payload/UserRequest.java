package com.web.project.modules.user.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.project.modules.role.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String username;
    private String password;
    private String fullName;
    private List<Long> roleIds;
    @JsonIgnore
    private List<Role> roles;
    private boolean active;
}

