package com.jestify.payload;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PodcastRequest {
    private String namePodcast;
    private String avatar;
}
