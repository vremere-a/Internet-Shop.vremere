package com.internet.shop.dao.impl;

import com.internet.shop.dao.ShoppingCartDAO;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.ShoppingCart;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Dao
public class ShoppingCartDaoImpl implements ShoppingCartDAO {
    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        Storage.addCart(shoppingCart);
        return shoppingCart;
    }

    @Override
    public Optional<ShoppingCart> getById(Long id) {
        return getAllShoppingCarts().stream()
                .filter(shoppingCart -> shoppingCart.getUserId().equals(id))
                .findFirst();
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        IntStream.range(0, Storage.shoppingCarts.size())
                .filter(i -> Storage.shoppingCarts.get(i).getId().equals(shoppingCart.getId()))
                .forEach(i -> Storage.shoppingCarts.set(i, shoppingCart));
        return shoppingCart;
    }

    @Override
    public boolean deleteById(Long id) {
        return Storage.shoppingCarts.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public List<ShoppingCart> getAllShoppingCarts() {
        return Storage.shoppingCarts;
    }
}
