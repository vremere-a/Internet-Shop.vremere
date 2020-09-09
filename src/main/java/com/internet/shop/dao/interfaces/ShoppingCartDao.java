package com.internet.shop.dao.interfaces;

import com.internet.shop.model.ShoppingCart;
import java.util.Optional;

public interface ShoppingCartDao extends GenericDao<ShoppingCart, Long> {

    public Optional<ShoppingCart> getByUserId(Long userId);
}
