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
public class Roles extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ROLE_ID")
    @SequenceGenerator(name = "ROLE_ID", sequenceName = "ROLE_ID_SEQ", allocationSize = 1)
    @Column(columnDefinition = "serial",name = "ID")
    private Long id;
    private String name;
    private String code;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "roles")
    private List<Users> users;
}