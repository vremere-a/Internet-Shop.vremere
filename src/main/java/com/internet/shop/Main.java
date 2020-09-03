package com.internet.shop;

import com.internet.shop.db.Storage;
import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.service.ProductService;

public class Main {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        productService.create(new Product("PS4", 500));
        productService.create(new Product("XBOX", 450));
        productService.create(new Product("Nintendo", 300));
        System.out.println("All Products:");
        Storage.products.forEach(System.out::println);
        System.out.println();
        productService.deleteById(2L);
        System.out.println("Delete product by ID 1");
        Storage.products.forEach(System.out::println);
        System.out.println();
        System.out.println("getById 1");
        System.out.println(productService.getById(1L));
        System.out.println();
        System.out.println("update PS4 to Sega");
        Product newProduct = new Product("Sega", 50);
        newProduct.setId(1L);
        productService.update(newProduct);
        System.out.println();
        Storage.products.forEach(System.out::println);
    }
}
