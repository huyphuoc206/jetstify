package com.jestify.service;

import com.jestify.converter.UserConverter;
import com.jestify.entity.Users;
import com.jestify.payload.*;
import com.jestify.repository.UserRepository;
import com.jestify.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<SongResponse> getSongs(Long artistId) {
        return songService.getSongsByArtistId(artistId);
    }

    public FollowResponse follow(FollowRequest followRequest) {
        return followService.follow(followRequest);
    }

    public List<PodcastResponse> getFollowsPodcast(String type) {
        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElseThrow(() -> new IllegalStateException("not Found User"));
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
    public void updateInfoUser(UserRequest userRequest){
        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElseThrow(()-> new IllegalStateException("Not Found User"));
        users.setAvatar(userRequest.getAvatar());
        users.setFullName(userRequest.getFullName());
        userRepository.save(users);
    }

}
