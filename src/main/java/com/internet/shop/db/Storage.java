package com.internet.shop.db;

import com.internet.shop.model.Order;
import com.internet.shop.model.Product;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Long productId = 0L;
    public static final List<Product> products = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();

    public static void addProduct(Product product) {
        product.setId(++productId);
        products.add(product);
    }
}
