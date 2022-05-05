package com.jestify.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Users extends BaseEntity {

    private String email;
    private String password;
    private String fullName;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
