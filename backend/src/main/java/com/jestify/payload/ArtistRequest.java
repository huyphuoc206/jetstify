package com.jestify.payload;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtistRequest {
    private String nickName;
    private String avatar;
}
