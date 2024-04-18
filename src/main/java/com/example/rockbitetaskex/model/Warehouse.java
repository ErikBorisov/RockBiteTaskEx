package com.example.rockbitetaskex.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "warehouse")
public class Warehouse extends BaseEntity {

    @Column
    private String name;


    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<Material> materials = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public void addMaterial(Material material) {
        material.setWarehouse(this);
        materials.add(material);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "name='" + name + '\'' +
                '}';
    }
}
