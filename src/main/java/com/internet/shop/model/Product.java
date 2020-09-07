package com.internet.shop.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private double price;
}
