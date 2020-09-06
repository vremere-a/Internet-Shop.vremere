package com.internet.shop.dao;

import com.internet.shop.model.ShoppingCart;
import java.util.List;
import java.util.Optional;

public interface ShoppingCartDAO {

    ShoppingCart create(ShoppingCart shoppingCart);

    Optional<ShoppingCart> getById(Long id);

    ShoppingCart update(ShoppingCart shoppingCart);

    boolean deleteById(Long id);

    List<ShoppingCart> getAllShoppingCarts();
}
