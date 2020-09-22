package com.internet.shop.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Order {
    private Long order_id;
    private List<Product> products;
    private User user;

    public Order(User user) {
        this.user = user;
        this.products = new ArrayList<>();
    }
    public Order(Long order_id, User user) {
        this.order_id = order_id;
        this.user = user;
        this.products = new ArrayList<>();
    }
}
