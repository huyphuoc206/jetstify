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
public class Songs extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SONG_ID")
    @SequenceGenerator(name = "SONG_ID", sequenceName = "SONG_ID_SEQ", allocationSize = 1)
    @Column(columnDefinition = "serial",name = "ID")
    private Long id;
    private String name;
    private String link;
    private String thumbnail;
    private boolean active;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "album_song",
    joinColumns = @JoinColumn(name = "album_id"),
    inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Albums> albums;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @OneToMany(mappedBy = "songs")
    private List<LikedSong> likedSongs;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "songs")
    private List<Playlists> playlists;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "song_user",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Users> users;
}
