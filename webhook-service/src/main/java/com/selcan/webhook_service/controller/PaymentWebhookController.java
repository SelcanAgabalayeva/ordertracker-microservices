package com.selcan.webhook_service.controller;

import com.selcan.webhook_service.dto.PaymentWebhookRequest;
import com.selcan.webhook_service.service.WebhookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks/payment")
@RequiredArgsConstructor
public class PaymentWebhookController {

    private final WebhookService webhookService;

    @PostMapping
    public void receive(@RequestBody PaymentWebhookRequest request) {
        webhookService.handlePayment(request);
    }
}