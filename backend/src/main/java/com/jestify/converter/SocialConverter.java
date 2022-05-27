package com.jestify.converter;

import com.jestify.entity.Socials;
import com.jestify.payload.SocialResponse;
import org.springframework.stereotype.Component;

@Component
public class SocialConverter {
    public SocialResponse toResponse(Socials entity){
        return SocialResponse.builder()
                .socialId(entity.getId())
                .link(entity.getLink())
                .name(entity.getName())
                .icon(entity.getIcon())
                .build();
    }
}
