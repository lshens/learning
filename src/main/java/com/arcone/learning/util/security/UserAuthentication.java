package com.arcone.learning.util.security;

import com.arcone.learning.exception.ForbiddenException;
import com.arcone.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
@Component
public class UserAuthentication {
    private final UserService service;

    public String id() {
        Authentication authentication = getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String id = service.getId(principal.getUsername());
        if (id.isBlank()) {
            throw new ForbiddenException();
        }
        return id;
    }

    public List<String> authorities() {
        return getAuthentication().getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(toList());
    }

    private static Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            throw new ForbiddenException();
        }
        return authentication;
    }
}
