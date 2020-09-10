package com.internet.shop.controllers.admin;

import com.internet.shop.library.Injector;
import com.internet.shop.model.Order;
import com.internet.shop.model.User;
import com.internet.shop.service.interfaces.OrderService;
import com.internet.shop.service.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/orders/all")
public class GetOrderAdminController extends HttpServlet {
    private static final Long USER_ID = 1L;
    private static Injector injector =
            Injector.getInstance("com.internet.shop");
    private OrderService orderService =
            (OrderService) injector.getInstance(OrderService.class);
    private final UserService userService =
            (UserService) injector.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Order> orders = orderService.getUserOrders(USER_ID);
        req.setAttribute("orders", orders);
        List<User> allUsers = userService.getAll();
        req.setAttribute("users", allUsers);
        req.getRequestDispatcher("/WEB-INF/views/orders/allAdmin.jsp")
                .forward(req, resp);
    }
}
