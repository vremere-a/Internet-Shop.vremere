package com.internet.shop.security.implementations;

import com.internet.shop.exeptions.AuthenticationException;
import com.internet.shop.library.Inject;
import com.internet.shop.library.Service;
import com.internet.shop.model.User;
import com.internet.shop.security.interfaces.AuthenticationService;
import com.internet.shop.service.interfaces.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
//    private static final String MESSAGE_ERROR = "Incorrect username or password";
    @Inject
    private UserService userService;

    @Override
    public User login(String login, String password) throws AuthenticationException {
        User userFromDB = userService.findByLogin(login).orElseThrow(() ->
                new AuthenticationException("Incorrect username or password"));

        if (userFromDB.getPassword().equals(password)) {
            return userFromDB;
        }
        throw new AuthenticationException("Incorrect username or password");
    }
}
