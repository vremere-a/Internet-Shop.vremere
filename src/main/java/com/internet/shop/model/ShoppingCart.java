package com.internet.shop.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ShoppingCart {
    private Long id;
    private List<Product> products;
    private Long userId;

    public ShoppingCart(Long userId) {
        this.userId = userId;
        this.products = new ArrayList<>();
    }

    public ShoppingCart(Long id, List<Product> products, Long userId) {
        this(id, userId);
        this.products = products;

    }

    public ShoppingCart(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    public ShoppingCart() {
    }
}
