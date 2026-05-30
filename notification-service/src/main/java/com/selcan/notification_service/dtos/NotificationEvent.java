package com.selcan.notification_service.dtos;

import lombok.Data;

@Data
public class NotificationEvent {
    private Long orderId;
    private String email;
    private String status;
}
