package com.ayupovmi.pmapp.entity;

import com.ayupovmi.pmapp.entity.Permission;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;

public enum RoleForSecurity {
    //USER(Set.of(Permission.USERS_READ)),
    //ADMIN(Set.of(Permission.USERS_READ, Permission.USERS_WRITE))
    ;

    private final Set<Permission> permissions;
    RoleForSecurity(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
