package com.jestify.service;

import com.jestify.converter.SongConverter;
import com.jestify.entity.Songs;
import com.jestify.payload.SongResponse;
import com.jestify.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final SongConverter songConverter;

    public List<SongResponse> getSongsByArtistId(Long artistID) {
        List<SongResponse> songResponseList = new ArrayList<>();
        List<Songs> songsList = songRepository.findByUsers_idAndActive(artistID, true);
        for (Songs song : songsList) {
            songResponseList.add(songConverter.toResponse(song));
        }
        return songResponseList;
    }

    public List<SongResponse> getSongsByCategoryId(Long categoryId) {
        return songRepository.findByCategoryIdAndActive(categoryId, true)
                .stream()
                .map(songConverter::toResponse)
                .collect(Collectors.toList());
    }

}
