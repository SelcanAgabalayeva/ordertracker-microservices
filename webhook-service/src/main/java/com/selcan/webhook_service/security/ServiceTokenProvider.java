package com.selcan.webhook_service.security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class ServiceTokenProvider {

    private final String secret;

    public ServiceTokenProvider(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    public String generateServiceToken() {

        return Jwts.builder()
                .setSubject("webhook-service")
                .claim("role", "SERVICE")
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }
}