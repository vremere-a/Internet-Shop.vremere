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

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private UserService userService = (UserService) injector.getInstance(UserService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String phoneString = req.getParameter("phone");
        Long phone = Long.valueOf(phoneString);
        String password = req.getParameter("pwd");
        String repeatPassword = req.getParameter("pwd-repeat");

        if (password.equals(repeatPassword)) {
            userService.create(new User(name,surname,email,phone,login,password));
            resp.sendRedirect(req.getContextPath() + "/");

        } else {
            req.setAttribute("message", "Your password and repeat password aren't the same.");
            req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/registration.jsp")
                .forward(req, resp);
    }
}
