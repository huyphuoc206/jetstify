package com.jestify.converter;

import com.jestify.entity.Follows;
import com.jestify.payload.FollowRequest;
import com.jestify.payload.FollowResponse;
import org.springframework.stereotype.Component;

@Component
public class FollowConverter {
    public Follows toEntity(FollowRequest followRequest) {
        return Follows.builder()
                .objectId(followRequest.getObjectId())
                .userId(followRequest.getUserId())
                .type(followRequest.getType())
                .build();
    }
    public FollowResponse toResponse(Follows entity){
        return FollowResponse
                .builder()
                .followId(entity.getId())
                .objectId(entity.getObjectId())
                .type(entity.getType())
                .userId(entity.getUserId())
                .build();
    }
}
