package com.example.client_1.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ARestCtrl {


    @GetMapping("/userinfo")
    public String getUserInfo(@AuthenticationPrincipal OidcUser oidcUser) {
        if (oidcUser != null) {
            // Получение информации о пользователе
            String username = oidcUser.getName();
            String email = oidcUser.getEmail();
            // Другие операции с информацией о пользователе
            return "Username: " + username + ", Email: " + email;
        } else {
            return "User information not available";
        }
    }
}
