package com.selcan.notification_service.service.impls;


import com.selcan.notification_service.dtos.EmailRequest;
import com.selcan.notification_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    @Async
    public void sendEmail(EmailRequest request) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());

        mailSender.send(message);
    }
}
