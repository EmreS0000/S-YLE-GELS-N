package com.rezarvasyon.saha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="order_id" ,nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "menuItem_id",nullable = false)
    private MenuItem menuItem;
    private String ProductName;
    private int quantity;
    private double price;
}
