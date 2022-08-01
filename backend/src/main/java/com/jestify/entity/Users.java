package com.jestify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "USER_ID")
    @SequenceGenerator(name = "USER_ID", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @Column(columnDefinition = "serial", name = "ID")
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private boolean active;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Roles roles;
    private String avatar;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<LikedSong> likedSongs;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Songs> songs;
    private String key;
    @Temporal(TemporalType.TIMESTAMP)
    private Date keyTime;
}