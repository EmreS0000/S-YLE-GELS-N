package com.example.soylegelsinprog.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Teslimat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Teslimatın benzersiz kimliği

    private String teslimatAdresi;  // Teslimat adresi
    private LocalDateTime teslimatTarihi;  // Teslimat tarihi
    private TeslimatDurumu durum;  // Teslimat durumu (YOLDA, TESLİM_EDİLDİ vb.)

    @ManyToOne
    @JoinColumn(name = "siparis_id")
    private Siparis siparis;  // Hangi siparişin teslimat bilgisi

    // Parametreli constructor
    public Teslimat(String teslimatAdresi, LocalDateTime teslimatTarihi, TeslimatDurumu durum, Siparis siparis) {
        this.teslimatAdresi = teslimatAdresi;
        this.teslimatTarihi = teslimatTarihi;
        this.durum = durum;
        this.siparis = siparis;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeslimatAdresi() {
        return teslimatAdresi;
    }

    public void setTeslimatAdresi(String teslimatAdresi) {
        this.teslimatAdresi = teslimatAdresi;
    }

    public LocalDateTime getTeslimatTarihi() {
        return teslimatTarihi;
    }

    public void setTeslimatTarihi(LocalDateTime teslimatTarihi) {
        this.teslimatTarihi = teslimatTarihi;
    }

    public TeslimatDurumu getDurum() {
        return durum;
    }

    public void setDurum(TeslimatDurumu durum) {
        this.durum = durum;
    }

    public Siparis getSiparis() {
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }

    @Override
    public String toString() {
        return "Teslimat [id=" + id + ", teslimatAdresi=" + teslimatAdresi + ", teslimatTarihi=" + teslimatTarihi +
                ", durum=" + durum + ", siparisId=" + siparis.getId() + "]";
    }
    // TeslimatDurumu enum sınıfı (nested)
    public enum TeslimatDurumu {
        YOLDA,        // Teslimat yolda
        TESLIM_EDILDI, // Teslim edildi
        IPTAL_EDILDI  // Teslimat iptal edildi
    }


}


