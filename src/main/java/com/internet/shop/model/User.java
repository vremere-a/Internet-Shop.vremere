package com.internet.shop.model;

import java.util.Set;
import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private byte[] salt;
    private Set<Role> roles;

    public User(String name, String surname, String email, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public User(Long id, String name, String surname, String email, String login, String password) {
        this(name, surname, email, login, password);
        this.id = id;

    }

    public User(Long id, String name, String surname,
                String email, String login, String password, Set<Role> roles) {
        this(id, name, surname, email, login, password);
        this.roles = roles;
    }

    public User() {
    }

}
