package com.selcan.logging_service.dto;

import lombok.Data;

@Data
public class LogRequest {
    private String serviceName;
    private String eventType;
    private String level;
    private String message;
}
