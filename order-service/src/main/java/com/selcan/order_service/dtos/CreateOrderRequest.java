package com.selcan.order_service.dtos;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private String productName;
    private Double amount;
    private String customerEmail;
}
