package com.internet.shop.controllers.order;

import com.internet.shop.library.Injector;
import com.internet.shop.model.Order;
import com.internet.shop.service.interfaces.OrderService;
import com.internet.shop.service.interfaces.ProductService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/orders/details")
public class ShowDetailsOrderController extends HttpServlet {
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private OrderService orderService =
            (OrderService) injector.getInstance(OrderService.class);
    private ProductService productService =
            (ProductService) injector.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        long orderId = Long.parseLong(id);
        Order order = orderService.getById(orderId);
        req.setAttribute("order", order);
        req.getRequestDispatcher("/WEB-INF/views/orders/detailOrder.jsp").forward(req, resp);
    }
}
