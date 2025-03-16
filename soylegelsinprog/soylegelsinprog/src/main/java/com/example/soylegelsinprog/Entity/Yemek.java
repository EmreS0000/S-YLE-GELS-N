package com.example.soylegelsinprog.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Yemek{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Yemeğin benzersiz kimliği

    private String name;  // Yemeğin adı
    private String description;  // Yemeğin açıklaması
    private Double price;  // Yemeğin fiyatı

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;  // Yemeğin ait olduğu restoran

    // Parametreli constructor
    public Yemek(String name, String description, Double price, Restaurant restaurant) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Dish [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", restaurant=" + restaurant.getName() + "]";
    }
}
