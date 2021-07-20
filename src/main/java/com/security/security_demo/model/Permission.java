package com.security.security_demo.model;

import lombok.Getter;

@Getter
public enum Permission {
    DEVELOPER_READ("developer:read"),
    DEVELOPER_WRITE("developer:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}
