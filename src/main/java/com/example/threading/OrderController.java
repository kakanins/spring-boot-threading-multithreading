package com.example.threading;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderProcessor orderProcessor;

    public OrderController(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @GetMapping("/process-orders")
    public String processOrders() {
        orderProcessor.processOrders(10); // Example: process 10 orders
        return "Order processing started!";
    }
}
