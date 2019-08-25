package com.github.magdau.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextService {

    public Authentication getCurrentContext() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
