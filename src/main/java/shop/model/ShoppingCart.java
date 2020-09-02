package shop.model;

import java.util.List;

public class ShoppingCart {
    private long id;
    private List<Product> products;
    private long userId;

    public ShoppingCart(List<Product> products, long userId) {
        this.products = products;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", products=" + products +
                ", userId=" + userId +
                '}';
    }
}
