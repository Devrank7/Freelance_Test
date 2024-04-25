package com.example.client_1.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
@Data
public class OidcServer {


    private OidcUser oidcUser;
}
