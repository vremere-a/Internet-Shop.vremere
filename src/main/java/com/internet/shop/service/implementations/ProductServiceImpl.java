package com.internet.shop.service.implementations;

import com.internet.shop.dao.interfaces.ProductDao;
import com.internet.shop.library.Inject;
import com.internet.shop.library.Service;
import com.internet.shop.model.Product;
import com.internet.shop.service.interfaces.ProductService;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Inject
    private ProductDao productDao;

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product getById(Long productId) {
        return productDao.getById(productId).get();
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean deleteById(Long productId) {
        return productDao.deleteById(productId);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }
}
