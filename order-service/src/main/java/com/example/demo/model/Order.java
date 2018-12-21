package com.example.demo.model;

import java.util.Date;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="customer_id", nullable = false)
    private Long customerId;

    @Column(name="total", nullable = false)
    private Double total;

    @Column(name="date_created", nullable = false)
    private Date dateCreated;
}
