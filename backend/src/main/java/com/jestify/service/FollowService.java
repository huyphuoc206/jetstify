package com.jestify.service;

import com.jestify.common.AppConstant;
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
        boolean existFollowType = followRepository.findByType(followRequest.getType()).isPresent();
        if (existFollowType)
            throw new IllegalStateException("Follow type is duplicated");
        Follows follows = followRepository.save(followConverter.toEntity(followRequest));
        return followConverter.toResponse(follows);
    }

    public List<FollowResponse> getFollows(Long userId) {
        List<FollowResponse> followResponses = new ArrayList<>();
        List<Follows> followsList = followRepository.findByUserId(userId);

        for (Follows follow : followsList) {
            switch (follow.getType()) {
                case AppConstant
                        .ARTIST: {
                    followResponses.add(followConverter.toResponse(follow));
                    break;
                }
                case AppConstant
                        .PODCAST: {
                    followResponses.add(followConverter.toResponse(follow));
                    break;
                }
                default: {
                    throw new IllegalStateException("Can't Follow");
                }
            }
        }
        return followResponses;
    }

    public List<FollowResponse> getListFollows(Long userId, String type) {
        List<FollowResponse> listFollow = getFollows(userId);
        List<FollowResponse> result = new ArrayList<>();
        for (FollowResponse follow : listFollow) {
            if (follow.getType().equals(type))
                result.add(follow);
        }
        return result;
    }
}
