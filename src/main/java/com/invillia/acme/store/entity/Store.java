package com.invillia.acme.store.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Store {

    private @Id @GeneratedValue Long id;
    private String name;
    private String address;

    public Store(){}

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }
}