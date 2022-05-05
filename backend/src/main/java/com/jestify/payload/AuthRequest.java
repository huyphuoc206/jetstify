package com.jestify.payload;

import lombok.*;

@Getter
@Setter
public class AuthRequest {
    private String email;
    private String password;
    private boolean isRemember;
}
