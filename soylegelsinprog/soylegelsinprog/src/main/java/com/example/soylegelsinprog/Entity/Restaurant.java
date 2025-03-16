package com.example.soylegelsinprog.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Restoranın benzersiz kimliği

    private String name;  // Restoran adı
    private String address;  // Restoran adresi
    private String contactInfo;  // Restoran iletişim bilgileri (telefon, e-posta vb.)
    private String openingHours;  // Restoranın çalışma saatleri

    // Parametreli constructor
    public Restaurant(String name, String address, String contactInfo, String openingHours) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.openingHours = openingHours;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", contactInfo=" + contactInfo + ", openingHours=" + openingHours + "]";
    }
}

