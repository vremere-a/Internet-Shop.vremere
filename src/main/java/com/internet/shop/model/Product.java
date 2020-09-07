package com.internet.shop.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Product {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private double price;
}
