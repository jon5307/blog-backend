package com.jon5307.blog.user;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetail implements UserDetails {

    private final SiteUser user;

    public CustomUserDetail(SiteUser user) {
        this.user = user;
    }

    @Override
    public @NotNull Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add((GrantedAuthority) () -> "ROLE_" + user.getRole());
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public @NotNull String getUsername() {
        return user.getUsername();
    }
}
