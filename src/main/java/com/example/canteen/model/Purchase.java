package com.example.canteen.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @Column(name = "purchase_date", columnDefinition = "DATE")
    private LocalDate PurchaseDate;

    public Purchase() {
    }

    public Purchase(Client client, LocalDate PurchaseDate) {
        this.client = client;
        this.PurchaseDate = PurchaseDate;
    }

    public Purchase(Long id, Client client, LocalDate PurchaseDate) {
        this.id = id;
        this.client = client;
        this.PurchaseDate = PurchaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDateDate) {
        this.PurchaseDate = purchaseDateDate;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", client=" + client +
                ", purchaseDate=" + PurchaseDate +
                '}';
    }
}
