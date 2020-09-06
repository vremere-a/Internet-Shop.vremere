package com.internet.shop.model;

import lombok.*;

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
