package com.internet.shop.controllers.inject;

import com.internet.shop.library.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.Role;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import com.internet.shop.service.interfaces.ProductService;
import com.internet.shop.service.interfaces.ShoppingCartService;
import com.internet.shop.service.interfaces.UserService;
import java.io.IOException;
import java.util.Set;
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
                "tom",
                "1");
        tom.setRoles(Set.of(Role.of("USER")));
        userService.create(tom);
        ShoppingCart shoppingCartTom = new ShoppingCart(tom.getId());
        shoppingCartService.create(shoppingCartTom);
        User admin = new User(
                "admin",
                "admin",
                "jason@ukr.net",
                "admin",
                "2");
        admin.setRoles(Set.of(Role.of("ADMIN")));
        userService.create(admin);
        ShoppingCart shoppingCartAdmin = new ShoppingCart(admin.getId());
        shoppingCartService.create(shoppingCartAdmin);
        req.getRequestDispatcher("/WEB-INF/views/injectData.jsp").forward(req, resp);
    }
}
