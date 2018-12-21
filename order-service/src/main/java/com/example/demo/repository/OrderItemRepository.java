package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{
    Optional<OrderItem> findById(Long id);

    void deleteOrderItemByOrderId(Long orderId);
}
