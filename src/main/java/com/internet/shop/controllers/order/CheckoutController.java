package com.internet.shop.controllers.order;

import com.internet.shop.library.Injector;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.service.interfaces.OrderService;
import com.internet.shop.service.interfaces.ShoppingCartService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkout/order")
public class CheckoutController extends HttpServlet {
    private static final Long USER_ID = 1L;
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private OrderService orderService =
            (OrderService) injector.getInstance(OrderService.class);
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) injector.getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ShoppingCart shoppingCart = shoppingCartService.getByUserId(USER_ID);
        orderService.completeOrder(shoppingCart);
        resp.sendRedirect(req.getContextPath() + "/orders/all");
    }
}
