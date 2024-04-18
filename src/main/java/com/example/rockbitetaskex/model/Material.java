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
@Table(name = "material")
public class Material extends BaseEntity {

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @JsonIgnore
    private Warehouse warehouse;

    @OneToOne(mappedBy = "material", cascade = CascadeType.ALL)
    @JoinColumn(name = "material_type_id")
    @JsonManagedReference
    private MaterialType materialType;


    public void addMaterialType(MaterialType materialType) {
        materialType.setMaterial(this);
    }

}
