package com.internet.shop.dao;

import com.internet.shop.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductDao {

    Product create(Product product);

    Optional<Product> geById(Long productId);

    Product update(Product product);

    boolean deleteById(Long productId);

    List<Product> getAllProducts();
}
