package com.example.demo.model;

import lombok.Data;

@Data
public class OrderInfo {
    private Long customerId;
    private Long productId;
    private int quantity;
}
