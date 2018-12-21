package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;

public interface OrderService
{
    List<Order> findAllOrders();

    Order save(Order order);

    OrderItem saveItem(OrderItem orderItem);

    void deleteById(Long id);

    void deleteItemByOrderId(Long orderId);
}
