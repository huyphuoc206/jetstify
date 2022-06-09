package com.jestify.service;

import com.jestify.converter.SongConverter;
import com.jestify.entity.Songs;
import com.jestify.payload.SongRequest;
import com.jestify.payload.SongResponse;
import com.jestify.repository.SongRepository;
import com.jestify.utils.AmazoneUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final SongConverter songConverter;
    private final AmazoneUtil amazoneUtil;

    public List<SongResponse> getSongsByArtistId(Long artistID) {
        List<SongResponse> songResponseList = new ArrayList<>();
        List<Songs> songsList = songRepository.findByUsers_idAndActive(artistID, true);
        for (Songs song : songsList) {
            songResponseList.add(songConverter.toResponse(song));
        }
        return songResponseList;
    }
    public SongResponse uploadSongs(SongRequest songRequest, MultipartFile file){
        songRequest.setLink(amazoneUtil.uploadFile(file));
        Songs songs = songRepository.save(songConverter.toEntity(songRequest));
        return songConverter.toResponse(songs);
    }

}
