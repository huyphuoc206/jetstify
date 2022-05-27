package com.jestify.service;

import com.jestify.converter.ArtistConverter;
import com.jestify.converter.ImageConverter;
import com.jestify.converter.SocialConverter;
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
    private final SongService songService;
    private final PodcastService podcastService;
    private final SocialService socialService;
    private final ArtistRepository artistRepository;
    private final ArtistConverter artistConverter;
    private final SocialConverter socialConverter;
    private final ImageConverter imageConverter;
    private final ImageService imageService;

    public List<SongResponse> getSongs(Long artistId) {
        return songService.getSongsByArtistId(artistId);
    }

    public List<PodcastResponse> getPodcasts(Long artistId) {
        return podcastService.getPodcastsByIdArtist(artistId);
    }
    public List<SocialResponse> getSocials(Long artistId) {
        return socialService.getSocialsByArtistId(artistId);
    }
    public List<ImageReponse> getImages(Long artistId) {
        return imageService.getImagesByArtistId(artistId);
    }

    public ArtistResponse getArtistById(Long artistId) {
        Artists artists = artistRepository.findById(artistId)
                .orElseThrow(() -> new IllegalStateException("Artist not found"));
        ArtistResponse artistResponse = artistConverter.toResponse(artists);
        artistResponse.setSocials(artists.getSocials().stream().map(socialConverter::toResponse).collect(Collectors.toList()));
        artistResponse.setImages(artists.getImages().stream().map(imageConverter::toResponse).collect(Collectors.toList()));
        return artistResponse;
    }
}
