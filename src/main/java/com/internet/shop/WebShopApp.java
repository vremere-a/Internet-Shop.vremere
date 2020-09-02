package com.internet.shop;

import com.internet.shop.db.Storage;
import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.service.ProductService;

public class WebShopApp {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);

        productService.create(new Product("iron1", 10));
        productService.create(new Product("iron2", 20));
        productService.create(new Product("iron4", 40));
        System.out.println(productService.getAllProducts());
        System.out.println();

//        Product product1 = new Product("iron1", 10);
//        Product product2 = new Product("iron2", 20);
//        Product product3 = new Product("iron3", 30);
//        Product product4 = new Product("iron4", 40);
//        Storage.addProduct(product1);
//        Storage.addProduct(product2);
//        Storage.addProduct(product3);
//        System.out.println(product1.getId());
//        System.out.println(product2.getName());
//        System.out.println(product1.getPrice());
//        System.out.println(Storage.products);
//        ProductService productService = new ProductServiceImpl();

//        System.out.println(productService.create(product4));
//        System.out.println(productService.delete(product1));


        Storage.products.forEach(System.out::println);

    }
}
