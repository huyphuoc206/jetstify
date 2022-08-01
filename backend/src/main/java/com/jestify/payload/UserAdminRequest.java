package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UserAdminRequest {
    private String fullName;
    private boolean active;
}
