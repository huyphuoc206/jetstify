package com.jestify.payload;

import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongRequest{
    private String link;
    private String name;
    private String thumbnail;
    private Long categoryId;
}
