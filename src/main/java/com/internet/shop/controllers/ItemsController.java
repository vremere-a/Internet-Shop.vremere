package com.internet.shop.controllers;

import com.internet.shop.library.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.service.interfaces.ProductService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/items/all")
public class ItemsController extends HttpServlet {
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private ProductService productService =
            (ProductService) injector.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Product> allProducts = productService.getAll();
        req.setAttribute("items", allProducts);
        req.getRequestDispatcher("/WEB-INF/views/items/all.jsp")
                .forward(req, resp);
    }
}
