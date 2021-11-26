package com.bookstore.entity;

import javax.persistence.*;

@Table(name = "order_detail", indexes = {
        @Index(name = "book_fk_2_idx", columnList = "book_id"),
        @Index(name = "order_fk_idx", columnList = "order_id")
})
@Entity
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderDetailId getId() {
        return id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }
}