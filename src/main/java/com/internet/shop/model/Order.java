package com.internet.shop.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Order {
    private Long orderId;
    private List<Product> products;
    private Long userId;

    public Order(Long userId) {
        this.userId = userId;
        this.products = new ArrayList<>();
    }

    public Order(Long orderId, Long userId) {
        this.orderId = orderId;
        this.userId = userId;
        this.products = new ArrayList<>();
    }

    public Order(Long orderId, Long userId, List<Product> products) {
        this(orderId, userId);
        this.products = products;
    }

    public Order() {
    }
}
