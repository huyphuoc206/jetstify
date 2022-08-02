package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class UserAdminResponse {
    private Long id;
    private String email;
    private String fullName;
    private Date createdDate;
    private Date updatedDate;
    private boolean active;
}
