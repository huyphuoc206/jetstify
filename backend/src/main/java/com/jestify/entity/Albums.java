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
public class Albums extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ALBUM_ID")
    @SequenceGenerator(name = "ALBUM_ID", sequenceName = "ALBUM_ID_SEQ", allocationSize = 1)
    @Column(columnDefinition = "serial",name = "ID")
    private Long id;
    private String name;
    private String description;
    private String thumbnail;
    private boolean active;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "album_song",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Songs> songs;
}
