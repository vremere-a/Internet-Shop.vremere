package com.internet.shop;

import com.internet.shop.db.Storage;
import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.service.ProductService;

public class Main {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);

        Product xbox = new Product("XBOX", 450);
        Product nintendo = new Product("Nintendo", 300);
        Product playStation = new Product("PS4", 500);
        productService.create(playStation);
        productService.create(xbox);
        productService.create(nintendo);

        System.out.println("All Products:");
        Storage.products.forEach(System.out::println);
        System.out.println("getById 1");
        System.out.println(playStation.getId());
        productService.deleteById(nintendo.getId());
        System.out.println("Delete product by ID 2");
        Storage.products.forEach(System.out::println);

        System.out.println("update price in PS4");
        playStation.setPrice(200);
        productService.update(playStation);
        Storage.products.forEach(System.out::println);
    }
}
