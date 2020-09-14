package com.internet.shop.security.interfaces;

import com.internet.shop.exeptions.AuthenticationException;
import com.internet.shop.model.User;

public interface AuthenticationService {
    User login (String login, String password) throws AuthenticationException;
}
