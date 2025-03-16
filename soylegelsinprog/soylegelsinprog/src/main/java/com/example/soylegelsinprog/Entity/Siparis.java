package com.example.soylegelsinprog.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Siparis{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Siparişin benzersiz kimliği

    private LocalDateTime orderDate;  // Siparişin verildiği tarih ve saat
    private Double totalAmount;  // Siparişin toplam tutarı
    private OrderStatus status;  // Sipariş durumu (PREPARING, DELIVERED vb.)
    private PaymentMethod paymentMethod;  // Ödeme yöntemi (CASH, CREDIT_CARD vb.)
    private DeliveryStatus deliveryStatus;  // Teslimat durumu (PENDING, OUT_FOR_DELIVERY, DELIVERED vb.)

    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;  // Siparişi veren kullanıcı (User -> Kullanici olarak değiştirildi)

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;  // Sipariş verilen restoran

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;  // Siparişe ait öğeler (yemekler)

    // Parametreli constructor
    public Siparis(LocalDateTime orderDate, Double totalAmount, SiparisDurumu status, PaymentMethod paymentMethod,
                 DeliveryStatus deliveryStatus, Kullanici kullanici, Restaurant restaurant, List<OrderItem> orderItems) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.SiparisDurumu = SiparisDurumu;
        this.paymentMethod = paymentMethod;
        this.deliveryStatus = deliveryStatus;
        this.kullanici = kullanici;
        this.restaurant = restaurant;
        this.orderItems = orderItems;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public SiparisDurumu getStatus() {
        return SiparisDurumu;
    }

    public void setStatus(SiparisDurumu status) {
        this.SiparisDurumu = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount +
                ", status=" + status + ", paymentMethod=" + paymentMethod + ", deliveryStatus=" + deliveryStatus +
                ", kullanici=" + kullanici.getName() + ", restaurant=" + restaurant.getName() + "]";
    }
    public enum SiparisDurumu
    {

        PREPARING,  // Hazırlanıyor
        DELIVERED,  // Teslim edildi
        CANCELLED   // İptal edildi
    }


}
