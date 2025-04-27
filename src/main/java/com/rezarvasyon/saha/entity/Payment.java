
package com.rezarvasyon.saha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    private String CardHolderName;
    private String CardNumber;
    private String expireDate;
    private String Cvv;

    private BigDecimal amount;

    private LocalDateTime paymentDate;
}