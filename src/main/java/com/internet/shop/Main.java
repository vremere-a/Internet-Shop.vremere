package com.internet.shop;

import com.internet.shop.dao.interfaces.OrderDao;
import com.internet.shop.dao.interfaces.ProductDao;
import com.internet.shop.dao.interfaces.ShoppingCartDao;
import com.internet.shop.dao.interfaces.UserDao;
import com.internet.shop.library.Injector;
import com.internet.shop.model.Order;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Product xbox = new Product("XBOX", 700.00);
    private static final Product nintendo = new Product("Nintendo", 500.00);
    private static final Product ps4 = new Product("PS4", 480.00);
    private static final Order order1 = new Order( 47L);
    private static final User user =
            new User("artsss", "vremere",
                    "av@ukt.net", "test3", "1");
    private static final User admin =
            new User("admin", "vremere",
                    "av@ukt.net", "admin2", "1");



    private static final ShoppingCart cart = new ShoppingCart(47L);


    private static Injector injector = Injector.getInstance("com.internet.shop");
    private static ProductDao productDao =
            (ProductDao) injector.getInstance(ProductDao.class);
    private static OrderDao orderDao =
            (OrderDao) injector.getInstance(OrderDao.class);
    private static UserDao userDao =
            (UserDao) injector.getInstance(UserDao.class);
    private static ShoppingCartDao shoppingCartDao =
            (ShoppingCartDao) injector.getInstance(ShoppingCartDao.class);

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(xbox);
        products.add(ps4);

                    /////USER//// - DONE
//        System.out.println("create user");
//        user.setRoles(Set.of(Role.of("USER")));
//        userDao.create(user);

//        System.out.println("get user by id");
//        System.out.println(userDao.getById(44L));

//        userDao.deleteById(44L);

//        userDao.update(new User(44L,"attt", "vremere",
//                "av@ukt.net", "test1", "1"));

//        System.out.print(userDao.getAll().toString());

//        System.out.println("get user by login");
//        System.out.println(userDao.findByLogin(user.getLogin()));

                    /////CART////
//        System.out.println("create cart");
//        System.out.println(shoppingCartDao.create(cart));

//            cart.setProducts(products);
//        cart.getProducts().add(xbox);
//        shoppingCartDao.update(cart);
//            shoppingCartDao.update(new ShoppingCart(14L, products, 47L));
//        System.out.println("get cart by id");
//        System.out.println(shoppingCartDao.getById(14L));

//        System.out.println("del cart by id");
//        System.out.println(shoppingCartDao.deleteById(3L));

//        System.out.println("getAll cart ");
//        System.out.println(shoppingCartDao.getAll());



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


                    /////ORDER////
        System.out.println("create order ");
        System.out.println(orderDao.create(order1));

//        System.out.println("get order by id");
//        System.out.println(orderDao.getById(9L));
        System.out.println("get all order");
        System.out.println(orderDao.getAll());
        System.out.println("get user order");
        System.out.println(orderDao.getUserOrders(2L));
        System.out.println("del order by id");
        System.out.println(orderDao.deleteById(order1.getOrderId()));





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
