package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CategoryPagingResponse {
    private List<CategoryResponse> categories;
    private long totalItems;
}
