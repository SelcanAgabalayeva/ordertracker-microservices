package com.selcan.webhook_service.service;

import com.selcan.webhook_service.dto.PaymentWebhookRequest;
import com.selcan.webhook_service.dto.ShipmentWebhookRequest;

public interface WebhookService {

    void handlePayment(PaymentWebhookRequest request);

    void handleShipment(ShipmentWebhookRequest request);
}
