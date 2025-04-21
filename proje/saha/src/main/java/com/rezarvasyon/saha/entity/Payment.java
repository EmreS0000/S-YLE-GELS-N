
package com.rezarvasyon.saha.entity;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
    private String PaymentMethod;
    private boolean isPaid;
}