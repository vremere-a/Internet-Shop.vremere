package com.internet.shop.controllers.inject;

import com.internet.shop.library.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.Role;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import com.internet.shop.service.interfaces.ProductService;
import com.internet.shop.service.interfaces.ShoppingCartService;
import com.internet.shop.service.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/inject-admin")
public class InjectAdminController extends HttpServlet {
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    private UserService userService = (UserService) injector.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
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
                "admin");
        admin.setRoles(Set.of(Role.of("ADMIN")));
        userService.create(admin);
        ShoppingCart shoppingCartAdmin = new ShoppingCart(admin.getId());
        shoppingCartService.create(shoppingCartAdmin);
        req.getRequestDispatcher("/WEB-INF/views/injectData.jsp").forward(req, resp);
    }
}
