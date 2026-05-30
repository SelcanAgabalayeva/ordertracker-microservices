package com.selcan.notification_service.controller;
import com.selcan.notification_service.dtos.NotificationEvent;
import com.selcan.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void notify(@RequestBody NotificationEvent event) {
        notificationService.processNotification(event);
    }
}
