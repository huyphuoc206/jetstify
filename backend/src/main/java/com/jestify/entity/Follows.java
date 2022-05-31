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
public class Follows extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "FOLLOW_ID")
    @SequenceGenerator(name = "FOLLOW_ID", sequenceName = "FOLLOW_ID_SEQ", allocationSize = 1)
    @Column(columnDefinition = "serial",name = "ID")
    private Long id;
    private Long userId;
    private Long objectId;
    private String type;
}
