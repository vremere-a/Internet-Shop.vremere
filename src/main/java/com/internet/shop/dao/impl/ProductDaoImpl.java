package com.internet.shop.dao.impl;

import com.internet.shop.dao.ProductDao;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Product;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

@Dao
public class ProductDaoImpl implements ProductDao {
    @Override
    public Product create(Product product) {
        Storage.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> geById(Long productId) {
        return Storage.products.stream()
                .filter(x -> Objects.equals(x.getId(), productId))
                .findFirst();
    }

    @Override
    public Product update(Product product) {
        IntStream.range(0, Storage.products.size())
                .filter(i -> Storage.products.get(i).getId() == (product.getId()))
                .forEach(i -> Storage.products.set(i, product));
        return product;
    }

    @Override
    public boolean deleteById(Long productId) {
        return Storage.products.remove(productId);
    }

    @Override
    public boolean delete(Product product) {
        IntStream.range(0, Storage.products.size())
                .filter(i -> Storage.products.get(i).getId() == (product.getId()))
                .forEach(i -> Storage.products.set(i, product));
        return Storage.products.remove(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return Storage.products;
    }
}
