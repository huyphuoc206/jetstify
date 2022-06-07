package com.jestify.service;

import com.jestify.converter.ArtistConverter;
import com.jestify.converter.ArtistPhotoConverter;
import com.jestify.entity.Artists;
import com.jestify.payload.*;
import com.jestify.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistConverter artistConverter;
    private final ArtistPhotoConverter artistPhotoConverter;
    private final ArtistPhotoService artistPhotoService;
    private final SongService songService;
    private final FollowService followService;


    public List<ArtistPhotoReponse> getPhotos(Long artistId) {
        return artistPhotoService.getPhotosByArtistId(artistId);
    }

    public List<SongResponse> getSongs(Long artistId) {
        return songService.getSongsByArtistId(artistId);
    }

    public ArtistResponse getArtistById(Long artistId) {
        Artists artists = artistRepository.findById(artistId)
                .orElseThrow(() -> new IllegalStateException("Artist not found"));
        ArtistResponse artistResponse = artistConverter.toResponse(artists);
        artistResponse.setPhotos(artists.getArtistPhotos().stream().map(artistPhotoConverter::toResponse).collect(Collectors.toList()));
        return artistResponse;
    }



    public List<ArtistResponse> getFollowsArtist(String type, Long userId) {
        List<FollowResponse> followResponseList = followService.getListFollows(userId, type);
        List<ArtistResponse> artistResponseList = new ArrayList<>();
        for (FollowResponse followResponse : followResponseList) {
            Artists artists = artistRepository.findById(followResponse.getObjectId()).orElseThrow(() -> new IllegalStateException("Not Found Artist to Follow"));
            artistResponseList.add(artistConverter.toResponse(artists));
        }
        return artistResponseList;
    }

}
