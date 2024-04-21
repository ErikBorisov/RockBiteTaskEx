package com.example.rockbitetaskex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "material")
public class Material extends BaseEntity {

    @Column
    private String name;

    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @JsonIgnore
    private Warehouse warehouse;

//    @OneToOne(mappedBy = "material", cascade = CascadeType.ALL)
//    @JoinColumn(name = "material_type_id")
//    @JsonManagedReference
//    private MaterialType materialType;


    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "material_materialType",
            joinColumns = {@JoinColumn(name = "material_id")},
            inverseJoinColumns = {@JoinColumn(name = "material_type_id")}
    )
    private MaterialType materialType;


//    public void addMaterialType(MaterialType materialType) {
//        materialType.setMaterial(this);
//    }

}
