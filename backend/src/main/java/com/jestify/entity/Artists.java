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

public class Artists extends BaseEntity{
    private int follow;
    @ManyToMany(mappedBy = "artists")
    private List<Songs> songs;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
    @OneToMany(mappedBy = "artists")
    private List<Podcasts> podcasts;
}
