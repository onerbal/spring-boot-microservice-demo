package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.OrderInfo;
import com.example.demo.model.OrderItem;
import com.example.model.ProductView;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/orders")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Value("${service.product.serviceId}")
    private String productServiceId;

    @GetMapping("")
    public List<Order> getAllOrders(HttpServletRequest request)
    {
        return orderService.findAllOrders();
    }

    @PostMapping("")
    public Order newOrder(@RequestBody OrderInfo orderInfo)
    {
        Application application = eurekaClient.getApplication(productServiceId);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/api/products/" + orderInfo.getProductId();
        System.out.println("URL" + url);
        ProductView product = restTemplate.getForObject(url, ProductView.class);
        System.out.println("RESPONSE " + product);

        Order order = new Order();
        order.setCustomerId(orderInfo.getCustomerId());
        order.setDateCreated(new Date());
        order.setTotal(product.getPrice() * orderInfo.getQuantity());
        order = orderService.save(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(order.getId());
        orderItem.setProductId(orderInfo.getProductId());
        orderItem.setQuantity(orderInfo.getQuantity());
        orderService.saveItem(orderItem);

        return order;
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Long id) {
        orderService.deleteItemByOrderId(id);
        orderService.deleteById(id);
    }
}
