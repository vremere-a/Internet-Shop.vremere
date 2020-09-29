package com.internet.shop.security.implementations;

import com.internet.shop.exeptions.AuthenticationException;
import com.internet.shop.library.Inject;
import com.internet.shop.library.Service;
import com.internet.shop.model.User;
import com.internet.shop.security.interfaces.AuthenticationService;
import com.internet.shop.service.interfaces.UserService;
import com.internet.shop.util.HashUtil;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String login, String password) throws AuthenticationException {
        Optional<User> userFromDB = userService.findByLogin(login);
        if (userFromDB.get().getPassword().equals(HashUtil.hashPassword(password,userFromDB.get().getSalt()))) {
            return userFromDB.get();
        }
        throw new AuthenticationException("Incorrect username or password");
    }
}
