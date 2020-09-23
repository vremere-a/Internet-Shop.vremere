package com.internet.shop.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Order {
    private Long order_id;
    private List<Product> products;
    private Long userId;

    public Order(Long userId) {
        this.userId = userId;
        this.products = new ArrayList<>();
    }
    public Order(Long order_id, Long userId) {
        this.order_id = order_id;
        this.userId = userId;
        this.products = new ArrayList<>();
    }
    public Order(Long order_id, Long userId, List<Product> products) {
        this.order_id = order_id;
        this.userId = userId;
        this.products = products;
    }
    public Order() {
    }
}
