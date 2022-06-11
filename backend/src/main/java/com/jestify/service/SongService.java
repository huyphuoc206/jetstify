package com.jestify.service;

import com.jestify.converter.SongConverter;
import com.jestify.entity.Category;
import com.jestify.entity.Songs;
import com.jestify.payload.SongRequest;
import com.jestify.payload.SongResponse;
import com.jestify.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

    public List<SongResponse> getSongsByArtistId(Long artistID) {
        List<SongResponse> songResponseList = new ArrayList<>();
        List<Songs> songsList = songRepository.findByUsers_idAndActive(artistID, true);
        for (Songs song : songsList) {
            songResponseList.add(songConverter.toResponse(song));
        }
        return songResponseList;
    }

    public SongResponse uploadSongs(SongRequest songRequest, MultipartFile multipartFile) {
        Category category = categoryRepository.findById(songRequest.getCategoryId()).orElseThrow(() -> new IllegalStateException("not found category"));
        Songs songs = songConverter.toEntity(songRequest);
        songs.setCategory(category);
        songs.setLink(amazoneUtil.uploadFile(multipartFile));
         songRepository.save(songs);
        return songConverter.toResponse(songs);
    }

}
