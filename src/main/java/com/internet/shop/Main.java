package com.internet.shop;

import com.internet.shop.db.Storage;
import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import com.internet.shop.service.OrderService;
import com.internet.shop.service.ProductService;
import com.internet.shop.service.ShoppingCartService;
import com.internet.shop.service.UserService;

public class Main {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {

        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        Product xbox = new Product("XBOX", 450);
        Product nintendo = new Product("Nintendo", 300);
        Product playStation = new Product("PS4", 500);
        Product sega = new Product("Sega", 70);
        Product dendy = new Product("Dendy", 50);
        Product subor = new Product("Subor", 60);
        Product tetris = new Product("Tetris", 10);
        productService.create(playStation);
        productService.create(xbox);
        productService.create(nintendo);
        productService.create(sega);
        productService.create(dendy);
        productService.create(subor);
        productService.create(tetris);

        UserService userService = (UserService) injector.getInstance(UserService.class);
        User user1 = new User("Tom","tom111", "111");
        User user2 = new User("Tim","tim222", "222");
        User user3 = new User("Ted","ted333", "333");
        userService.create(user1);
        userService.create(user2);
        userService.create(user3);

        ShoppingCartService shoppingCartService =
                (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        ShoppingCart shoppingCartUser1 = new ShoppingCart(user1.getId());
        ShoppingCart shoppingCartUser2 = new ShoppingCart(user2.getId());
        ShoppingCart shoppingCartUser3 = new ShoppingCart(user3.getId());
        ShoppingCart shoppingCartUser2new = new ShoppingCart(user2.getId());
        shoppingCartService.create(shoppingCartUser1);
        shoppingCartService.create(shoppingCartUser3);
        shoppingCartService.create(shoppingCartUser2);
        shoppingCartService.create(shoppingCartUser2new);

        System.out.println("Add Product to Cart:");
        shoppingCartService.addProduct(shoppingCartUser1,playStation);
        shoppingCartService.addProduct(shoppingCartUser1,xbox);
        shoppingCartService.addProduct(shoppingCartUser1,nintendo);
        shoppingCartService.addProduct(shoppingCartUser2,tetris);
        shoppingCartService.addProduct(shoppingCartUser2,sega);
        shoppingCartService.addProduct(shoppingCartUser3,sega);
        shoppingCartService.addProduct(shoppingCartUser3,dendy);
        shoppingCartService.addProduct(shoppingCartUser3,subor);
        shoppingCartService.addProduct(shoppingCartUser2new,playStation);
        Storage.shoppingCarts.forEach(System.out::println);

        System.out.println("Delete xbox from Cart#1:");
        shoppingCartService.deleteProduct(shoppingCartUser1,xbox);
        Storage.shoppingCarts.forEach(System.out::println);

        System.out.println("get ID by User#3");
        System.out.println(shoppingCartService.getByUserId(user3.getId()));

        System.out.println("delete Cart ID #2");
        shoppingCartService.delete(shoppingCartUser3);
        Storage.shoppingCarts.forEach(System.out::println);

        System.out.println("Clear all product by Cart#1");
        shoppingCartService.clear(shoppingCartUser1);
        Storage.shoppingCarts.forEach(System.out::println);

        OrderService orderService = (OrderService) injector.getInstance(OrderService.class);
        System.out.println("complete order User#2");
        orderService.completeOrder(shoppingCartUser2);
        orderService.completeOrder(shoppingCartUser2new);
        Storage.orders.forEach(System.out::println);
        Storage.shoppingCarts.forEach(System.out::println);

        System.out.println("get User#2 orders");
        System.out.println(orderService.getUserOrders(user2.getId()));

        System.out.println("get User#2 order by ID");
        System.out.println(orderService.get(user2.getId()));

        System.out.println("get All orders");
        orderService.getAll();
        Storage.orders.forEach(System.out::println);

        System.out.println("del order by ID");
        orderService.delete(user2.getId());
        Storage.orders.forEach(System.out::println);
    }
}
