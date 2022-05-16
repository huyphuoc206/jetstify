package com.jestify.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
}
