package com.internet.shop;

import com.internet.shop.dao.interfaces.OrderDao;
import com.internet.shop.dao.interfaces.ProductDao;
import com.internet.shop.dao.interfaces.UserDao;
import com.internet.shop.database.Storage;
import com.internet.shop.library.Injector;
import com.internet.shop.model.Order;
import com.internet.shop.model.Product;
import com.internet.shop.model.Role;
import com.internet.shop.model.User;

import java.util.Set;

import static com.internet.shop.model.Role.RoleName.USER;

public class Main {
    private static final Product xbox = new Product("XBOX", 700.00);
    private static final Product nintendo = new Product("Nintendo", 500.00);
    private static final Product ps4 = new Product("PS4", 480.00);
    private static final Order order1 = new Order( 2L);
    private static final User user =
            new User("arts", "vremere",
                    "av@ukt.net", "d", "4");
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private static ProductDao productDao =
            (ProductDao) injector.getInstance(ProductDao.class);
    private static OrderDao orderDao =
            (OrderDao) injector.getInstance(OrderDao.class);
    private static UserDao userDao =
            (UserDao) injector.getInstance(UserDao.class);

    public static void main(String[] args) {
        System.out.println("create user");
        user.setId(7L);
        user.setRoles(Set.of(Role.of("USER")));
        System.out.println(userDao.create(user));

//        productDao.create(xbox);
//        productDao.create(nintendo);
//        productDao.create(ps4);
//
//        System.out.println(productDao.getById(61L).toString());
//        System.out.println(productDao.getAll().toString());
//        productDao.update(new Product(61L, "X", 111));
//        System.out.println(productDao.getById(61L).toString());
//        productDao.deleteById(61L);
//        System.out.println(productDao.getAll().toString());

//        System.out.println("create order User#2");
//        System.out.println(orderDao.create(order1));
//        System.out.println("get order by id");
//        System.out.println(orderDao.getById(9L));
//        System.out.println("get all order");
//        System.out.println(orderDao.getAll());
//        System.out.println("get user order");
//        System.out.println(orderDao.getUserOrders(2L));
//        System.out.println("del order by id");
//        System.out.println(orderDao.deleteById(order1.getOrder_id()));





//        orderDao.create(shoppingCartUser2);
//        orderDao.create(shoppingCartUser2new);
//        Storage.orders.forEach(System.out::println);
//        Storage.shoppingCarts.forEach(System.out::println);
//
//        System.out.println("get User#2 orders");
//        System.out.println(orderDao.getUserOrders(a.getId()));
//
//        System.out.println("get User#2 order by ID");
//        System.out.println(orderDao.getById(a.getId()));
//
//        System.out.println("get All orders");
//        orderDao.getAll();
//        Storage.orders.forEach(System.out::println);
//
//        System.out.println("del order by ID");
//        orderDao.deleteById(a.getId());
//        Storage.orders.forEach(System.out::println);

    }
}
