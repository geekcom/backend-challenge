package com.invillia.acme.store.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    public Store() {}

    public Store(
            String name,
            String address
    ) {
        this.name = name;
        this.address = address;
    }
}