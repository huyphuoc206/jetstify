package com.jestify.service;

import com.jestify.converter.SocialConverter;
import com.jestify.entity.Socials;
import com.jestify.payload.SocialResponse;
import com.jestify.repository.SocialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialService {
    private final SocialRepository socialRepository;
    private final SocialConverter socialConverter;
    public List<SocialResponse> getSocialsByArtistId(Long artistId){
        List<SocialResponse> socialResponses = new ArrayList<>();
        List<Socials> socials = socialRepository.findByArtists_idAndActive(artistId, true);
        for (Socials social : socials) {
            socialResponses.add(socialConverter.toResponse(social));
        }
        return socialResponses;
    }
}
