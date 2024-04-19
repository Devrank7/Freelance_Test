package com.example.client_1.jwt;

import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthValue {
    @Autowired
    private static JwtUtils jwtUtils;

    public static int userId() {
return 0;

    }
}
