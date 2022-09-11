package com.example.canteen.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Client client;
    @Column(name = "order_date", columnDefinition = "DATE")
    private LocalDate orderDate;

    public Order() {
    }

    public Order(Client client, LocalDate orderDate) {
        this.client = client;
        this.orderDate = orderDate;
    }

    public Order(Long id, Client client, LocalDate orderDate) {
        this.id = id;
        this.client = client;
        this.orderDate = orderDate;
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", orderDate=" + orderDate +
                '}';
    }
}
