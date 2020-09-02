package com.internet.shop;

import com.internet.shop.db.Storage;
import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;

public class WebShopApp {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        Product product1 = new Product("iron1", 10);
        Product product2 = new Product("iron2", 20);
        Product product3 = new Product("iron3", 30);
        Storage.addProduct(product1);
        Storage.addProduct(product2);
        Storage.addProduct(product3);

        Storage.products.forEach(System.out::println);

    }
}
