package com.internet.shop;

import com.internet.shop.db.Storage;
import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.User;
import com.internet.shop.service.ProductService;
import com.internet.shop.service.UserService;

public class Main {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
//        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        UserService userService = (UserService) injector.getInstance(UserService.class);

        User user1 = new User("Tom","tom111", "111");
        User user2 = new User("Tim","tim222", "222");
        User user3 = new User("Ted","ted333", "333");
        userService.create(user1);
        userService.create(user2);
        userService.create(user3);
        System.out.println("All Users:");
        Storage.users.forEach(System.out::println);
        System.out.println("getById 2");
        System.out.println(userService.get(user2.getId()));
        System.out.println("delete by ID 3");
        userService.delete(user3.getId());
        Storage.users.forEach(System.out::println);
        System.out.println("update password in user 2");
        user2.setPassword("2225");
        userService.update(user2);
        Storage.users.forEach(System.out::println);



//        Product xbox = new Product("XBOX", 450);
//        Product nintendo = new Product("Nintendo", 300);
//        Product playStation = new Product("PS4", 500);
//        productService.create(playStation);
//        productService.create(xbox);
//        productService.create(nintendo);
//
//        System.out.println("All Products:");
//        Storage.products.forEach(System.out::println);
//        System.out.println("getById 1");
//        System.out.println(playStation.getId());
//        productService.deleteById(nintendo.getId());
//        System.out.println("Delete product by ID 2");
//        Storage.products.forEach(System.out::println);
//
//        System.out.println("update price in PS4");
//        playStation.setPrice(200);
//        productService.update(playStation);
//        Storage.products.forEach(System.out::println);
    }
}
