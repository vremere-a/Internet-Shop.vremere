package com.internet.shop.dao;

import com.internet.shop.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    User create(User shoppingCart);

    Optional<User> getById(User id);

    User update(User shoppingCart);

    boolean deleteById(Long id);

    List<User> getAllProducts();
}
