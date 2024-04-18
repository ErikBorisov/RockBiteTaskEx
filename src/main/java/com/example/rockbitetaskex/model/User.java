package com.example.rockbitetaskex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "user_name")
    private String userName;

    //    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user", referencedColumnName = "id")
    @JsonManagedReference
    private List<Warehouse> warehouses = new ArrayList<>();


    public void addWarehouse(Warehouse warehouse) {
        warehouse.setUser(this);
        warehouses.add(warehouse);
    }

}
