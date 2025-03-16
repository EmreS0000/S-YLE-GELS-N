package com.example.soylegelsinprog.Entity;

import jakarta.persistence.*;

@Entity
public class Degerlendirme { // Review yerine Türkçe isim kullanıldı

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Değerlendirmenin benzersiz kimliği

    private String yorum; // Kullanıcının yaptığı yorum
    private Integer puan; // Yıldız puanı (1-5 arası)

    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici; // Yorumu yapan kullanıcı

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant; // Yorum yapılan restoran

    // Parametreli constructor
    public Degerlendirme(String yorum, Integer puan, Kullanici kullanici, Restaurant restaurant) {
        this.yorum = yorum;
        this.puan = puan;
        this.kullanici = kullanici;
        this.restaurant = restaurant;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public Integer getPuan() {
        return puan;
    }

    public void setPuan(Integer puan) {
        this.puan = puan;
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

    @Override
    public String toString() {
        return "Degerlendirme [id=" + id + ", yorum=" + yorum + ", puan=" + puan +
                ", kullanici=" + kullanici.getName() + ", restaurant=" + restaurant.getName() + "]";
    }
}
