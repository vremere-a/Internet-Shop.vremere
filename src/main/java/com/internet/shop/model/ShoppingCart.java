package com.internet.shop.model;

import java.util.List;

public class ShoppingCart {
    private Long id;
    private List<Product> products;
    private Long userId;

    public ShoppingCart(Long id, List<Product> products, Long userId) {
        this.id = id;
        this.products = products;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
