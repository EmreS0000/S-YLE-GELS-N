package com.rezarvasyon.saha.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Restoran")
public class Restoran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phoneNumber")
    private int phoneNumber;
    @OneToMany(mappedBy = "restoran",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MenuItem> menuItems=new ArrayList<>();

}
