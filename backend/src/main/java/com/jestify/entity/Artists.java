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
    private int follow;
    private String thumbnail;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "artists")
    private List<Songs> songs;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artists")
    private List<Podcasts> podcasts;
    private String info;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artists")
    private List<Socials> socials;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artists")
    private List<Images> images;
}
