package com.selcan.notification_service.dtos;

import lombok.Data;

@Data
public class EmailRequest {
    private String to;
    private String subject;
    private String message;
}
