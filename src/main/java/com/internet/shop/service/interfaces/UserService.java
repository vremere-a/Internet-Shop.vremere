package com.internet.shop.service.interfaces;

import com.internet.shop.model.User;
import java.util.Optional;

public interface UserService extends GenericService<User, Long> {

    User update(User user);

    Optional<User> findByLogin(String login);
}
