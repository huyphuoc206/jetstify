package com.jestify.service;

import com.jestify.common.AppConstant;
import com.jestify.converter.ArtistConverter;
import com.jestify.converter.ArtistPhotoConverter;
import com.jestify.entity.ArtistPhoto;
import com.jestify.entity.Artists;
import com.jestify.entity.Follows;
import com.jestify.entity.Users;
import com.jestify.payload.*;
import com.jestify.repository.ArtistPhotoRepository;
import com.jestify.repository.ArtistRepository;
import com.jestify.repository.FollowRepository;
import com.jestify.repository.UserRepository;
import com.jestify.utils.AmazonUtil;
import com.jestify.utils.JsonUtil;
import com.jestify.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistConverter artistConverter;
    private final ArtistPhotoConverter artistPhotoConverter;
    private final ArtistPhotoService artistPhotoService;
    private final ArtistPhotoRepository artistPhotoRepository;
    private final SongService songService;
    private final FollowService followService;
    private final FollowRepository followRepository;
    private final UserRepository userRepository;
    private final AmazonUtil amazonUtil;


    public List<ArtistPhotoReponse> getPhotos(Long artistId) {
        return artistPhotoService.getPhotosByArtistId(artistId);
    }

    public List<SongResponse> getSongs(Long artistId) {
        return songService.getSongsByArtistId(artistId);
    }


    public ArtistResponse getArtistInfo() {

        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently())
                .orElseThrow(() -> new IllegalStateException("Not Found User"));
        Artists artists = artistRepository.findByUserId(users.getId())
                .orElseThrow(() -> new IllegalStateException("Artist not found"));
        ArtistResponse artistResponse = artistConverter.toResponse(artists);

        artistResponse.setSongResponseList(songService.getSongByCurrentUser().stream().map(e -> {
            e.setNameArtist(artists.getNickName());
            return e;
        }).collect(Collectors.toList()));


        artistResponse.setPhotos(artists.getArtistPhotos()
                .stream()
                .map(artistPhotoConverter::toResponse)
                .collect(Collectors.toList()));
        artistResponse.setFullNameUser(users.getFullName());
        List<Follows> totalFollowers = followRepository.findByTypeAndObjectId(AppConstant.ARTIST, artists.getId());
        artistResponse.setTotalFollowers(totalFollowers.size());
        return artistResponse;
    }

    public ArtistResponse getArtistById(Long artistId) {
        Artists artists = artistRepository.findById(artistId)
                .orElseThrow(() -> new IllegalStateException("Artist not found"));
        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently())
                .orElse(null);
        ArtistResponse artistResponse = artistConverter.toResponse(artists);
        if (users != null) {
            Optional<Follows> follows = followRepository
                    .findByObjectIdAndTypeAndUserId(artistId, AppConstant.ARTIST, users.getId());
            follows.ifPresent(value -> artistResponse
                    .setFollowId(value.getId()));
        }
        artistResponse.setPhotos(artists.getArtistPhotos()
                .stream()
                .map(artistPhotoConverter::toResponse)
                .collect(Collectors.toList()));
        List<Follows> totalFollowers = followRepository.findByTypeAndObjectId(AppConstant.ARTIST, artists.getId());
        artistResponse.setTotalFollowers(totalFollowers.size());
        return artistResponse;
    }


    public List<ArtistResponse> getFollowsArtist(String type, Long userId) {
        List<FollowResponse> followResponseList = followService.getListFollows(userId, type);
        List<ArtistResponse> artistResponseList = new ArrayList<>();
        for (FollowResponse followResponse : followResponseList) {
            Artists artists = artistRepository
                    .findById(followResponse.getObjectId())
                    .orElseThrow(() -> new IllegalStateException("Not Found Artist to Follow"));
            ArtistResponse artistResponse = artistConverter.toResponse(artists);
            artistResponse.setPhotos(artists.getArtistPhotos()
                    .stream()
                    .map(artistPhotoConverter::toResponse)
                    .collect(Collectors.toList()));
            artistResponseList.add(artistResponse);
        }
        return artistResponseList;
    }

    @Transactional
    public void updateInfoArtist(String artistRequestJson, MultipartFile fileImg) {
        ArtistRequest artistRequest = JsonUtil.toObject(artistRequestJson, ArtistRequest.class);

        Users users = userRepository.findByEmailAndActiveTrue(UserUtil.getUserCurrently()).orElseThrow(() -> new IllegalStateException("Not Found User"));
        Artists artists = artistRepository.findByUserId(users.getId()).orElse(null);

        List<ArtistPhoto> artistPhotos = artistPhotoRepository.findByArtists_idAndActive(artists.getId(), true);
        ArtistPhoto artistPhoto = new ArtistPhoto();
        if (CollectionUtils.isEmpty(artistPhotos)) {
            artistPhoto.setArtists(artists);
            artistPhoto.setLink(amazonUtil.uploadFile(fileImg));
            artistPhoto.setActive(true);
            artistPhoto = artistPhotoRepository.save(artistPhoto);
            artistPhotos.add(artistPhoto);
        } else if (fileImg != null) {
            artistPhotos.get(0).setLink(amazonUtil.uploadFile(fileImg));
        }

        if (fileImg != null) {
            artists.setArtistPhotos(artistPhotos);
        }

        artists.setNickName(artistRequest.getNickName());
        artistRepository.save(artists);
    }

}
