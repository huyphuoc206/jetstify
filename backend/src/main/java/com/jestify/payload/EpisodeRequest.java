package com.jestify.payload;

import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeRequest {
    private String name;
    private String link;
    private String thumbnail;
    private String description;
}
