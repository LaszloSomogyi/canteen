package com.example.canteen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PurchaseItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "purchase_id", nullable = false)
    private Purchase purchase;
    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private Integer qty;

    public PurchaseItem() {
    }

    public PurchaseItem(Purchase purchase, Product product, Integer qty) {
        this.purchase = purchase;
        this.product = product;
        this.qty = qty;
    }

    public PurchaseItem(Long id, Purchase purchase, Product product, Integer qty) {
        this.id = id;
        this.purchase = purchase;
        this.product = product;
        this.qty = qty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
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
        return "PurchaseItem{" +
                "id=" + id +
                ", Purchase=" + purchase +
                ", product=" + product +
                ", qty=" + qty +
                '}';
    }
}
