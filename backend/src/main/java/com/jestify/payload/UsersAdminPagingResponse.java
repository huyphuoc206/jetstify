package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class UsersAdminPagingResponse {
    private List<UserAdminResponse> users;
    private long totalItems;
}
