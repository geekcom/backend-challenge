package com.invillia.acme.user.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    public User(){}

    public User(
            String name,
            String email,
            String password
            ){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}