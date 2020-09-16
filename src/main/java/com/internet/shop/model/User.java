package com.internet.shop.model;

import lombok.Data;
import lombok.NonNull;
import java.util.Set;

@Data
public class User {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String email;
    @NonNull
    private String login;
    @NonNull
    private String password;

    private Set<Role> roles;
}
