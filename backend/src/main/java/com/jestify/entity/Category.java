package com.jestify.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Category extends BaseEntity {
    private String name;
    private String code;
    private boolean active;
}