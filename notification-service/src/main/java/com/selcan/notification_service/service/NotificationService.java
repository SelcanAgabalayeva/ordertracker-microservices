package com.selcan.notification_service.service;

import com.selcan.notification_service.dtos.NotificationEvent;

public interface NotificationService {
    void processNotification(NotificationEvent event);
}
