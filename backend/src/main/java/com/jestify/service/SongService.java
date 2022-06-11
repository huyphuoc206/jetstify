package com.jestify.service;

import com.jestify.converter.SongConverter;
import com.jestify.entity.Category;
import com.jestify.entity.Songs;
import com.jestify.payload.SongRequest;
import com.jestify.payload.SongResponse;
import com.jestify.repository.CategoryRepository;
import com.jestify.repository.SongRepository;
import com.jestify.utils.AmazonUtil;
import com.jestify.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final SongConverter songConverter;
    private final AmazonUtil amazonUtil;
    private final CategoryRepository categoryRepository;

    public List<SongResponse> getSongsByArtistId(Long artistID) {
        List<SongResponse> songResponseList = new ArrayList<>();
        List<Songs> songsList = songRepository.findByUsers_idAndActive(artistID, true);
        for (Songs song : songsList) {
            songResponseList.add(songConverter.toResponse(song));
        }
        return songResponseList;
    }

    @Transactional
    public SongResponse uploadSongs(MultipartFile fileMp3, MultipartFile fileJpg, String songRequestJson) {
        SongRequest songRequest = JsonUtil.toObject(songRequestJson, SongRequest.class);
        Category category = categoryRepository.findById(songRequest.getCategoryId()).orElseThrow(() -> new IllegalStateException("not found category"));
        Songs songs = songConverter.toEntity(songRequest);
        songs.setCategory(category);
        songs.setLink(amazonUtil.uploadFile(fileMp3));
        songs.setThumbnail(amazonUtil.uploadFile(fileJpg));
        songs.setActive(true);
        songRepository.save(songs);
        return songConverter.toResponse(songs);
    }

    public List<SongResponse> getSongsByCategoryId(Long categoryId) {
        return songRepository.findByCategoryIdAndActive(categoryId, true)
                .stream()
                .map(songConverter::toResponse)
                .collect(Collectors.toList());
    }

}
