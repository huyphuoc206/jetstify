package com.jestify.service;

import com.jestify.converter.UserConverter;
import com.jestify.entity.Users;
import com.jestify.payload.*;
import com.jestify.repository.UserRepository;
import com.jestify.utils.AmazonUtil;
import com.jestify.utils.JsonUtil;
import com.jestify.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final SongService songService;
    private final FollowService followService;
    private final PodcastService podcastService;
    private final ArtistService artistService;
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final AmazonUtil amazonUtil;

    public List<SongResponse> getSongs(Long artistId) {
        return songService.getSongsByArtistId(artistId);
    }

    public FollowResponse follow(FollowRequest followRequest) {
        return followService.follow(followRequest);
    }

    public List<PodcastResponse> getFollowsPodcast(String type) {
        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently())
                .orElseThrow(() -> new IllegalStateException("not Found User"));
        return podcastService.getFollowsPodcast(type, users.getId());
    }

    public List<ArtistResponse> getFollowsArtist(String type) {
        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElseThrow(() -> new IllegalStateException("not Found User"));
        return artistService.getFollowsArtist(type, users.getId());
    }
    public UserResponse getInfoUser(){
        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElseThrow(()-> new IllegalStateException("Not Found User"));
        return userConverter.toResponse(users);
    }

    @Transactional
    public void updateInfoUser(String userRequestJson, MultipartFile fileImg){
        UserRequest userRequest = JsonUtil.toObject(userRequestJson, UserRequest.class);
        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElseThrow(()-> new IllegalStateException("Not Found User"));
        users.setAvatar(amazonUtil.uploadFile(fileImg));
        users.setFullName(userRequest.getFullName());
        userRepository.save(users);
    }

}
