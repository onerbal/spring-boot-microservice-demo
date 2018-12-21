package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_order_products")
public class OrderItem {

    @Id
    @Column(name="order_id", nullable = false)
    private Long orderId;

    @Column(name="product_id", nullable = false)
    private Long productId;

    @Column(nullable = false)
    private int quantity;
}
