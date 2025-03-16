package com.example.soylegelsinprog.Entity;


import jakarta.persistence.*;

@Entity
public class Adres { // Address yerine Türkçe isim kullanıldı

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Adresin benzersiz kimliği

    private String sokak; // Sokak adı
    private String sehir; // Şehir adı
    private String postaKodu; // Posta kodu

    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici; // Adresin sahibi (kullanıcı)

    // Parametreli constructor
    public Adres(String sokak, String sehir, String postaKodu, Kullanici kullanici) {
        this.sokak = sokak;
        this.sehir = sehir;
        this.postaKodu = postaKodu;
        this.kullanici = kullanici;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSokak() {
        return sokak;
    }

    public void setSokak(String sokak) {
        this.sokak = sokak;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getPostaKodu() {
        return postaKodu;
    }

    public void setPostaKodu(String postaKodu) {
        this.postaKodu = postaKodu;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    @Override
    public String toString() {
        return "Adres [id=" + id + ", sokak=" + sokak + ", sehir=" + sehir +
                ", postaKodu=" + postaKodu + ", kullanici=" + kullanici.getName() + "]";
    }
}
