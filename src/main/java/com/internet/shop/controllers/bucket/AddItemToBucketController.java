package com.internet.shop.controllers.bucket;

import com.internet.shop.library.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.service.interfaces.ProductService;
import com.internet.shop.service.interfaces.ShoppingCartService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/item/add/bucket")
public class AddItemToBucketController extends HttpServlet {
    private static final Long USER_ID = 1L;
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    private ProductService productService =
            (ProductService) injector.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ShoppingCart shoppingCart = shoppingCartService.getByUserId(USER_ID);
        String userId = req.getParameter("id");
        Long id = Long.valueOf(userId);
        Product product = productService.getById(id);
        shoppingCartService.addProduct(shoppingCart,product);
        resp.sendRedirect(req.getContextPath() + "/all/items/bucket");
    }

}
