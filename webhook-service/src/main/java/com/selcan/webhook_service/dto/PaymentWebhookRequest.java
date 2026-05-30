package com.selcan.webhook_service.dto;
import lombok.Data;

@Data
public class PaymentWebhookRequest {
    private Long orderId;
    private String status; // SUCCESS / FAILED
    private String transactionId;
}
