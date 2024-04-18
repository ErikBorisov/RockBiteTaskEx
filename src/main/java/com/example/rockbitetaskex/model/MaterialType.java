package com.example.rockbitetaskex.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "material_type")
public class MaterialType extends BaseEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String icon;

    @Column
    private Long maxCapacity;

    @OneToOne
    @JoinColumn(name = "material_id")
    @JsonBackReference
    private Material material;
}
