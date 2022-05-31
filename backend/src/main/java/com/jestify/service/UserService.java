package com.jestify.service;

import com.jestify.payload.SongResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final SongService songService;
    public List<SongResponse> getSongs(Long artistId) {
        return songService.getSongsByArtistId(artistId);
    }

}
