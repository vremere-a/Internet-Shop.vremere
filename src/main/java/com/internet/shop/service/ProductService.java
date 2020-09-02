package com.internet.shop.service;

import com.internet.shop.model.Product;
import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product geById(Long productId);

    Product update(Product product);

    boolean deleteById(Long productId);

    boolean delete(Product product);

    List<Product> getAllProducts();
}
