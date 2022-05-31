package com.jestify.service;

import com.jestify.converter.ImageConverter;
import com.jestify.payload.ImageReponse;
import com.jestify.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final ImageConverter imageConverter;

    public List<ImageReponse> getImagesByArtistId(Long artistId) {
        List<ImageReponse> imageResponses = new ArrayList<>();
        List<Images> images = imageRepository.findByArtists_idAndActive(artistId, true);
        for (Images image : images) {
            imageResponses.add(imageConverter.toResponse(image));
        }
        return imageResponses;
    }
}
