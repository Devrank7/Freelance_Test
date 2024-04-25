package com.example.client_1.oauth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class OAuthSuccussesHandle extends org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
       CustomerOAuthUser oAuthUser = (CustomerOAuthUser) authentication.getPrincipal();
        System.out.println(oAuthUser.getName());
        super.onAuthenticationSuccess(request, response, chain, authentication);
    }
}
