package com.internet.shop.service.impl;

import com.internet.shop.dao.ShoppingCartDAO;
import com.internet.shop.lib.Inject;
import com.internet.shop.lib.Service;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Inject
    private ShoppingCartDAO shoppingCartDAO;

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        return shoppingCartDAO.create(shoppingCart);
    }

    @Override
    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product product) {
//          shoppingCart.getProducts().add(product);
        return shoppingCartDAO.addProduct(shoppingCart,product);
//        return shoppingCart;
    }

    @Override
    public boolean deleteProduct(ShoppingCart shoppingCart, Product product) {
        return shoppingCartDAO.deleteProduct(shoppingCart,product);
//       return shoppingCart.getProducts().remove(product);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
//        shoppingCart.getProducts().removeAll(shoppingCart.getProducts());
        shoppingCartDAO.clear(shoppingCart);
    }

    @Override
    public ShoppingCart getByUserId(Long userId) {
        return shoppingCartDAO.getById(userId).get();
    }

    @Override
    public boolean delete(ShoppingCart shoppingCart) {
        return shoppingCartDAO.deleteById(shoppingCart.getId());
    }
}
