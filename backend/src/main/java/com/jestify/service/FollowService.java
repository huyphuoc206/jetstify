package com.jestify.service;

import com.jestify.converter.FollowConverter;
import com.jestify.entity.Follows;
import com.jestify.payload.FollowRequest;
import com.jestify.payload.FollowResponse;
import com.jestify.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    private final FollowConverter followConverter;

    public FollowResponse follow(FollowRequest followRequest) {
        Follows follows = followRepository.save(followConverter.toEntity(followRequest));
        return followConverter.toResponse(follows);
    }

    public List<FollowResponse> getListFollows(Long userId, String type) {
        List<Follows> listFollow = followRepository.findByTypeAndUserId(type, userId);
        List<FollowResponse> result = new ArrayList<>();
        for (Follows follow : listFollow) {
            result.add(followConverter.toResponse(follow));
        }
        return result;
    }

    public void unFollow(Long followId) {
        Follows follows = followRepository.findById(followId).orElseThrow(()->new IllegalStateException("Not Follow"));
        followRepository.delete(follows);
    }
}
