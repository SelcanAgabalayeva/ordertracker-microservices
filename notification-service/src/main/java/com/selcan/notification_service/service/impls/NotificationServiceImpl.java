package com.selcan.notification_service.service.impls;

import com.selcan.notification_service.dtos.EmailRequest;
import com.selcan.notification_service.dtos.NotificationEvent;
import com.selcan.notification_service.service.EmailService;
import com.selcan.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final EmailService emailService;

    @Override
    public void processNotification(NotificationEvent event) {

        EmailRequest email = new EmailRequest();

        email.setTo(event.getEmail());
        email.setSubject("Order Update #" + event.getOrderId());
        email.setMessage("Your order status is now: " + event.getStatus());

        emailService.sendEmail(email);
    }
}
