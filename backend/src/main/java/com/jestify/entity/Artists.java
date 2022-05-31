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

public class Artists extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ARTIST_ID")
    @SequenceGenerator(name = "ARTIST_ID", sequenceName = "ARTIST_ID_SEQ", allocationSize = 1)
    @Column(columnDefinition = "serial",name = "ID")
    private Long id;
    private Long userId;
    private String thumbnail;
    private String info;
    private boolean verify;
    private String nickName;
    private String facebook;
    private String instagram;
    private String twitter;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "artists")
    List<ArtistPhoto> artistPhotos;
}
