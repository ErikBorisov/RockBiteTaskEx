package com.example.rockbitetaskex.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString

@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "user_name")
    private String userName;
}
