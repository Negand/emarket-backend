package com.rvs.emarket.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserPrincipal implements UserDetails {

    private final User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();

        // Roles → ROLE_ADMIN, ROLE_USER, etc.
        if (user.getRoles() != null) {
            user.getRoles().forEach(role ->
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()))
            );
        }

        // Permisos → READ_USER, CREATE_PRODUCT, etc.
        if (user.getPermissions() != null) {
            user.getPermissions().forEach(permission ->
                    authorities.add(new SimpleGrantedAuthority(permission.getName()))
            );
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // modificar si manejas expiración
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // modificar si manejas bloqueo
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // modificar si manejas expiración de credenciales
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    // Getter para acceder al objeto User completo si hace falta
    public User getUser() {
        return user;
    }
}
