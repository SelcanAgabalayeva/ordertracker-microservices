package com.selcan.webhook_service.controller;
import com.selcan.webhook_service.dto.ShipmentWebhookRequest;
import com.selcan.webhook_service.service.WebhookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks/shipment")
@RequiredArgsConstructor
public class ShipmentWebhookController {

    private final WebhookService webhookService;

    @PostMapping
    public void receive(@RequestBody ShipmentWebhookRequest request) {
        webhookService.handleShipment(request);
    }
}
