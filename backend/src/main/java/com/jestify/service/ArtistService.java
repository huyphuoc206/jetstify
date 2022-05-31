package com.jestify.service;

import com.jestify.converter.ArtistConverter;
import com.jestify.converter.ArtistPhotoConverter;
import com.jestify.entity.Artists;
import com.jestify.payload.*;
import com.jestify.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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



    public List<ArtistPhotoReponse> getPhotos(Long artistId) {
        return artistPhotoService.getPhotosByArtistId(artistId);
    }
    public List<SongResponse> getSongs(Long artistId){
        return songService.getSongsByArtistId(artistId);
    }

    public ArtistResponse getArtistById(Long artistId) {
        Artists artists = artistRepository.findById(artistId)
                .orElseThrow(() -> new IllegalStateException("Artist not found"));
        ArtistResponse artistResponse = artistConverter.toResponse(artists);
        artistResponse.setPhotos(artists.getArtistPhotos().stream().map(artistPhotoConverter::toResponse).collect(Collectors.toList()));
        return artistResponse;
    }
}
