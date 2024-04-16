package com.example.rockbitetaskex.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "warehouse")
public class Warehouse extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
