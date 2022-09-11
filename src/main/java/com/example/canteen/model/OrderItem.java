package com.example.canteen.model;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Order order;
    private Product product;
    private Integer qty;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer qty) {
        this.order = order;
        this.product = product;
        this.qty = qty;
    }

    public OrderItem(Long id, Order order, Product product, Integer qty) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.qty = qty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", qty=" + qty +
                '}';
    }
}
