package com.internet.shop.controllers.admin;

import com.internet.shop.library.Injector;
import com.internet.shop.model.Order;
import com.internet.shop.service.interfaces.OrderService;
import com.internet.shop.service.interfaces.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/orders")
public class GetAllOrdersAdminController extends HttpServlet {
    private static Injector injector =
            Injector.getInstance("com.internet.shop");
    private OrderService orderService =
            (OrderService) injector.getInstance(OrderService.class);
    private final UserService userService =
            (UserService) injector.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Order> orders = orderService.getAll();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/WEB-INF/views/admin/allOrdersAdmin.jsp").forward(req, resp);
    }
}
