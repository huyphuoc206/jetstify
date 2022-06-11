package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class SongRequest{
    private String link;
    private String name;
    private String thumbnail;
    private Long categoryId;
}
