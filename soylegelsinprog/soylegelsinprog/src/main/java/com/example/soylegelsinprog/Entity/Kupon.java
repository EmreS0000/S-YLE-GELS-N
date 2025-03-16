package com.example.soylegelsinprog.Entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Kupon { // Coupon yerine Türkçe isim kullanıldı

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Kuponun benzersiz kimliği

    private String kod; // Kupon kodu
    private Double indirimMiktari; // İndirim tutarı veya oranı
    private LocalDateTime sonKullanmaTarihi; // Kuponun geçerlilik süresi

    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici; // Kuponu kullanan kullanıcı

    // Parametreli constructor
    public Kupon(String kod, Double indirimMiktari, LocalDateTime sonKullanmaTarihi, Kullanici kullanici) {
        this.kod = kod;
        this.indirimMiktari = indirimMiktari;
        this.sonKullanmaTarihi = sonKullanmaTarihi;
        this.kullanici = kullanici;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Double getIndirimMiktari() {
        return indirimMiktari;
    }

    public void setIndirimMiktari(Double indirimMiktari) {
        this.indirimMiktari = indirimMiktari;
    }

    public LocalDateTime getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(LocalDateTime sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    @Override
    public String toString() {
        return "Kupon [id=" + id + ", kod=" + kod + ", indirimMiktari=" + indirimMiktari +
                ", sonKullanmaTarihi=" + sonKullanmaTarihi + ", kullanici=" + kullanici.getName() + "]";
    }
}
