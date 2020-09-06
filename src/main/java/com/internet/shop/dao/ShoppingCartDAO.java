package com.internet.shop.dao;

import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartDAO {

    ShoppingCart create(ShoppingCart shoppingCart);

    Optional<ShoppingCart> getById(Long id);

    boolean deleteById(Long id);

    List<ShoppingCart> getAllShoppingCarts();

    ShoppingCart addProduct(ShoppingCart shoppingCart, Product product);

    boolean deleteProduct(ShoppingCart shoppingCart, Product product);

    void clear(ShoppingCart shoppingCart);
}
