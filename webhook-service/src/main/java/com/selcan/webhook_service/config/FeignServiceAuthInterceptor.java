package com.selcan.webhook_service.config;

import com.selcan.webhook_service.security.ServiceTokenProvider;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceAuthInterceptor implements RequestInterceptor {

    private final ServiceTokenProvider tokenProvider;

    public FeignServiceAuthInterceptor(ServiceTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void apply(RequestTemplate template) {

        String token = tokenProvider.generateServiceToken();

        template.header("Authorization", "Bearer " + token);
    }
}
