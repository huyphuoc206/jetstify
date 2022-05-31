package com.jestify.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CATEGORY_ID")
    @SequenceGenerator(name = "CATEGORY_ID", sequenceName = "CATEGORY_ID_SEQ", allocationSize = 1)
    @Column(columnDefinition = "serial",name = "ID")
    private Long id;
    private String name;
    private String code;
    private boolean active;
    private Long parentId;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category")
    private List<Songs> songs;
}