package com.example.soylegelsinprog.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Odeme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Ödemenin benzersiz kimliği

    private Double amount;  // Ödeme tutarı
    private OdemeIslemi status;  // Ödeme durumu (tamamlandı, beklemede vb.)
    private LocalDateTime paymentDate;  // Ödeme tarihi

    @ManyToOne
    @JoinColumn(name = "siparis_id")
    private Siparis siparis;  // Hangi sipariş için ödeme yapıldığı

    // Parametreli constructor
    public Odeme(Double amount, OdemeIslemi status, LocalDateTime paymentDate, Siparis siparis) {
        this.amount = amount;
        this.status = status;
        this.paymentDate = paymentDate;
        this.siparis = siparis;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OdemeIslemi getStatus() {
        return status;
    }

    public void setStatus(OdemeIslemi status) {
        this.status = status;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Siparis getSiparis() {
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }

    @Override
    public String toString() {
        return "Odeme [id=" + id + ", amount=" + amount + ", status=" + status + ", paymentDate=" + paymentDate + "]";
    }

    // OdemeIslemi enum sınıfı (nested)
    public enum OdemeIslemi {
        TAMAMLANDI,  // Ödeme tamamlandı
        BEKLEMEDE,   // Ödeme beklemede
        BASARISIZ    // Ödeme başarısız
    }
}
