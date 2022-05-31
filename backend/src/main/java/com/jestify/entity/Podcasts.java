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
public class Podcasts extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PODCAST_ID")
    @SequenceGenerator(name = "PODCAST_ID", sequenceName = "PODCAST_ID_SEQ", allocationSize = 1)
    @Column(columnDefinition = "serial",name = "ID")
    private Long id;
    private String thumbnail;
    private Long userId;
    private String name;
    private String description;
    private boolean active;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "podcasts")
    List<Episodes> episodes;
}
