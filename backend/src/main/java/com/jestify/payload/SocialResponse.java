package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SocialResponse {
    private String name;
    private String link;
    private Long socialId;
    private String icon;
}
