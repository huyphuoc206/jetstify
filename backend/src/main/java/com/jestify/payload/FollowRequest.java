package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class FollowRequest {
    private String type;
    private Long userId;
    private Long objectId;
    private Long followId;
}
