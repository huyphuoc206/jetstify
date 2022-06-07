package com.jestify.service;

import com.jestify.payload.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    public List<PodcastResponse> getFollowsPodcast(String type) {
        return podcastService.getFollowsPodcast(type);
    }

    public List<ArtistResponse> getFollowsArtist(String type) {
        return artistService.getFollowsArtist(type);
    }

    public String checkUserCurrently() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getPrincipal().toString();
        System.out.println(currentEmail);
        return currentEmail;
    }
}
