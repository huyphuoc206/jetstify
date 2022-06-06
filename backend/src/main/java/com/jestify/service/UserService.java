package com.jestify.service;

import com.jestify.payload.*;
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

    public List<SongResponse> getSongs(Long artistId) {
        return songService.getSongsByArtistId(artistId);
    }

    public FollowResponse follow(FollowRequest followRequest) {
        return followService.follow(followRequest);
    }


    public List<PodcastResponse> getFollowsPodcast(Long userId) {
        return podcastService.getFollowsPodcast(userId);
    }

    public List<ArtistResponse> getFollowsArtist(Long userId) {
        return artistService.getFollowsArtist(userId);
    }

}
