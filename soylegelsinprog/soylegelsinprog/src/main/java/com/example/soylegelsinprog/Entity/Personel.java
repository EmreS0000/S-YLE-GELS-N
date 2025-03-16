package com.example.soylegelsinprog.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Personelin benzersiz ID'si

    private String name; // Personelin adı
    private String role; // Personelin rolü (örneğin, şef, kurye, müşteri temsilcisi vb.)
    private String email; // Personelin e-posta adresi
    private String phoneNumber; // Personelin telefon numarası



    // Parametreli constructor
    public Personel(String name, String role, String email, String phoneNumber) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
    }
}
