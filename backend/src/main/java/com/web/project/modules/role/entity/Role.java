package com.web.project.modules.role.entity;

import com.web.project.common.BaseEntity;
import com.web.project.modules.user.entity.Users;
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
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(columnDefinition = "serial")
    private Long id;
    private String name;
    private String code;
    @ManyToMany(mappedBy = "roles")
    private List<Users> users;
}
