package com.internet.shop.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String login;
    @NonNull
    private String password;
}
