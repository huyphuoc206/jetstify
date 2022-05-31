package com.jestify.service;

import com.jestify.converter.ArtistPhotoConverter;
import com.jestify.entity.ArtistPhoto;
import com.jestify.payload.ArtistPhotoReponse;
import com.jestify.repository.ArtistPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistPhotoService {
    private final ArtistPhotoRepository artistPhotoRepository;
    private final ArtistPhotoConverter artistPhotoConverter;

    public List<ArtistPhotoReponse> getPhotosByArtistId(Long artistId) {
        List<ArtistPhotoReponse> artistPhotoReponses = new ArrayList<>();
        List<ArtistPhoto> artistPhotos = artistPhotoRepository.findByArtists_idAndActive(artistId, true);
        for (ArtistPhoto photo : artistPhotos) {
            artistPhotoReponses.add(artistPhotoConverter.toResponse(photo));
        }
        return artistPhotoReponses;
    }
}
