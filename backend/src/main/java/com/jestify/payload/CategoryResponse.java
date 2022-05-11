package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String name;
    private String code;
    private Date createdDate;
    private Date updatedDate;
}
