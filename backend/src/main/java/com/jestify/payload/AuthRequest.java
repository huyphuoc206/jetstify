package com.jestify.payload;

import lombok.*;

@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
    private boolean isRemember;
}
