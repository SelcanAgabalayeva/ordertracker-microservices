package com.selcan.order_service.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()

                        // USER operations
                        .requestMatchers(HttpMethod.GET, "/api/orders/**")
                        .hasAnyRole("USER", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/orders/**")
                        .hasAnyRole("USER", "ADMIN")

                        // SERVICE ONLY (IMPORTANT)
                        .requestMatchers(HttpMethod.PUT, "/api/orders/**")
                        .hasRole("SERVICE")

                        .requestMatchers(HttpMethod.DELETE, "/api/orders/**")
                        .hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}