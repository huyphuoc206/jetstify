package com.jestify.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ArtistPhoto extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ARTIST_PHOTO_ID")
    @SequenceGenerator(name = "ARTIST_PHOTO_ID", sequenceName = "ARTIST_PHOTO_ID_SEQ", allocationSize = 1)
    @Column(columnDefinition = "serial",name = "ID")
    private Long id;
    private String link;
    private boolean active;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artists artists;
}
