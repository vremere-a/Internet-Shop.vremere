package com.internet.shop.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Role {
    private long id;
    private RoleName roleName;

    private Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public static Role of(String roleName) {
        return new Role(RoleName.valueOf(roleName));
    }

    public enum RoleName {
        USER, ADMIN;
    }
}
