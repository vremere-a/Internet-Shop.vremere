package com.internet.shop.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private List<Product> products;
    private Long userId;

    public Order(Long userId) {
        this.userId = userId;
        this.products = new ArrayList<>();
    }
}
