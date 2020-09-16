package com.internet.shop.controllers.order;

import com.internet.shop.library.Injector;
import com.internet.shop.model.Order;
import com.internet.shop.service.interfaces.OrderService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/orders")
public class GetUserOrdersController extends HttpServlet {
    private static final String USER_ID = "user_id";
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private OrderService orderService =
            (OrderService) injector.getInstance(OrderService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute(USER_ID);
        List<Order> orders = orderService.getUserOrders(userId);
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/WEB-INF/views/orders/all.jsp").forward(req, resp);
    }
}
