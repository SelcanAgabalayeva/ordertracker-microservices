package com.selcan.webhook_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private String productName;
    private Double amount;
    private String status;
    private String customerEmail;
}
