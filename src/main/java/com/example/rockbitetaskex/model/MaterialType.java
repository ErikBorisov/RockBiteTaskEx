package com.example.rockbitetaskex.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class MaterialType extends BaseEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String icon;

    @Column
    private Long maxCapacity;

}
