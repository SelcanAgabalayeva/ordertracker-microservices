package com.selcan.notification_service.service;

import com.selcan.notification_service.dtos.EmailRequest;

public interface EmailService {
    void sendEmail(EmailRequest request);
}
