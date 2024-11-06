package com.example.threading;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class OrderProcessor {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5); // Thread pool

    public void processOrders(int numberOfOrders) {
        for (int i = 1; i <= numberOfOrders; i++) {
            int orderId = i;
            executorService.submit(() -> processOrder(orderId));
        }
        executorService.shutdown();
    }

    private void processOrder(int orderId) {
        System.out.println("Processing order #" + orderId + " on thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulate time-consuming task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
