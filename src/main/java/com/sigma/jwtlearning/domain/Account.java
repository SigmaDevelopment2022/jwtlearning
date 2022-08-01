package com.sigma.jwtlearning.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class Account implements UserDetails {
    private long id;
    private String username;
    private String email;
    private String password;
    private String authorities;
    private String created;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.isEmpty() ? null :
                Arrays.stream(authorities.split(","))
                .map(it -> new SimpleGrantedAuthority(it.trim()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
