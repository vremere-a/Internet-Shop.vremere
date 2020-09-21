package com.internet.shop;

import com.internet.shop.dao.interfaces.ProductDao;
import com.internet.shop.dao.jdbc.ProductDaoJdbcImpl;
import com.internet.shop.model.Product;

public class Main {

    private static final Product xbox = new Product("XBOX", 700.00);
    private static final Product nintendo = new Product("Nintendo", 500.00);
    private static final Product ps4 = new Product("PS4", 480.00);

    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoJdbcImpl();
        productDao.create(xbox);
        productDao.create(nintendo);
        productDao.create(ps4);

        System.out.println(productDao.getById(1L).toString());
        System.out.println(productDao.getAll().toString());
        productDao.update(new Product(1L, "update", 111));
        System.out.println(productDao.getById(1L).toString());
        productDao.deleteById(1L);
        System.out.println(productDao.getAll().toString());
    }
}
