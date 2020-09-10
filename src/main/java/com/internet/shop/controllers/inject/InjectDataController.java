package com.internet.shop.controllers.inject;

import com.internet.shop.library.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import com.internet.shop.service.interfaces.ProductService;
import com.internet.shop.service.interfaces.ShoppingCartService;
import com.internet.shop.service.interfaces.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inject-data")
public class InjectDataController extends HttpServlet {
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private ProductService productService =
            (ProductService) injector.getInstance(ProductService.class);
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    private UserService userService = (UserService) injector.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        productService.create(new Product("XBOX", 700.00));
        productService.create(new Product("Nintendo", 500.00));
        productService.create(new Product("PS4", 480.00));
        productService.create(new Product("Sega", 520.00));
        productService.create(new Product("Tetris", 300.00));
        User tom = new User(
                "Tom",
                "Scott",
                "sobaka@ukr.net",
                0123L,
                "tom-s",
                "123");
        User tim = new User(
                "Tim",
                "Jason",
                "jason@ukr.net",
                23223L,
                "tim-j",
                "321");
        User ted = new User(
                "Ted",
                "Lee",
                "lee@ukr.net",
                2L,
                "ted-l",
                "111");
        userService.create(tom);
        userService.create(tim);
        userService.create(ted);
        shoppingCartService.create(new ShoppingCart(tom.getId()));
        shoppingCartService.create(new ShoppingCart(tim.getId()));
        shoppingCartService.create(new ShoppingCart(ted.getId()));
        req.getRequestDispatcher("/WEB-INF/views/injectData.jsp").forward(req, resp);
    }
}
