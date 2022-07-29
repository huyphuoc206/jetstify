package com.jestify.service;

import com.jestify.converter.SongConverter;
import com.jestify.entity.Artists;
import com.jestify.entity.Category;
import com.jestify.entity.Songs;
import com.jestify.entity.Users;
import com.jestify.payload.SongRequest;
import com.jestify.payload.SongResponse;
import com.jestify.repository.ArtistRepository;
import com.jestify.repository.CategoryRepository;
import com.jestify.repository.SongRepository;
import com.jestify.repository.UserRepository;
import com.jestify.utils.AmazonUtil;
import com.jestify.utils.JsonUtil;
import com.jestify.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final SongConverter songConverter;
    private final UserRepository userRepository;
    private final AmazonUtil amazonUtil;
    private final ArtistRepository artistRepository;
    private final CategoryRepository categoryRepository;

    public List<SongResponse> getSongsByArtistId(Long artistID) {
        List<SongResponse> songResponseList = new ArrayList<>();
        Artists artists = artistRepository.findById(artistID).orElse(null);
        Users users = userRepository.findById(artists.getUserId()).orElse(null);
        List<Songs> songsList = songRepository.findByUsers_idAndActive(users.getId(), true);
        for (Songs song : songsList) {
            songResponseList.add(songConverter.toResponse(song));
        }
        return songResponseList;
    }
    public List<SongResponse> getSongByCurrentUser(){
        List<SongResponse> songResponseList = new ArrayList<>();
        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElse(null);
        List<Songs> songsList = songRepository.findByUsers_idAndActive(users.getId(), true);
        for (Songs song : songsList) {
            songResponseList.add(songConverter.toResponse(song));
        }
        return songResponseList;
    }

    @Transactional
    public SongResponse uploadSongs(MultipartFile fileMp3, MultipartFile fileJpg, String songRequestJson) {

        if(fileMp3.isEmpty()) throw new IllegalStateException("File Mp3 Not Null");

        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElseThrow(() -> new IllegalStateException("not found User"));
        SongRequest songRequest = JsonUtil.toObject(songRequestJson, SongRequest.class);
        Category category = categoryRepository.findById(songRequest.getCategoryId()).orElseThrow(() -> new IllegalStateException("not found category"));
        Songs songs = songConverter.toEntity(songRequest);
        songs.setCategory(category);
        songs.setLink(amazonUtil.uploadFile(fileMp3));
        songs.setThumbnail(amazonUtil.uploadFile(fileJpg));
        songs.setActive(true);
        songs.setUsers(Collections.singletonList(users));
        songRepository.save(songs);
        return songConverter.toResponse(songs);
    }

    public List<SongResponse> getSongsByCategoryId(Long categoryId) {
        return songRepository.findByCategoryIdAndActive(categoryId, true)
                .stream()
                .map(songConverter::toResponse)
                .collect(Collectors.toList());
    }
    @Transactional
    public void updateSong(Long songId, String songRequestJson,MultipartFile fileMp3,MultipartFile fileJpg){
        Songs songs = songRepository.findById(songId).orElse(null);
        SongRequest songRequest = JsonUtil.toObject(songRequestJson, SongRequest.class);
        Category category = categoryRepository.findById(songRequest.getCategoryId()).orElseThrow(() -> new IllegalStateException("not found category"));
        songs.setName(songRequest.getName());
        songs.setThumbnail(amazonUtil.uploadFile(fileJpg));
        songs.setLink(amazonUtil.uploadFile(fileMp3));
        songs.setCategory(category);
        songRepository.save(songs);
    }

    public void deleteSong(Long songId){
        Songs songs = songRepository.findById(songId).orElse(null);
        songs.setActive(false);
        songRepository.save(songs);
    }
}
