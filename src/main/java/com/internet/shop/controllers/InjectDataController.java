package com.internet.shop.controllers;

import com.internet.shop.library.Injector;
import com.internet.shop.model.User;
import com.internet.shop.service.interfaces.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/injectData")
public class InjectDataController extends HttpServlet {
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private UserService userService = (UserService) injector.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        User tom = new User("Tom", "tom111", "111");
//        User tim = new User("Tim", "tim222", "222");
//        userService.create(tom);
//        userService.create(tim);

        req.getRequestDispatcher("/WEB-INF/views/injectData.jsp").forward(req,resp);
    }
}
