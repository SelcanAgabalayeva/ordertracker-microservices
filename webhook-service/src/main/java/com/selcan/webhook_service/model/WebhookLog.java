package com.selcan.webhook_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "webhook_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WebhookLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType;

    @Lob
    private String payload;

    private LocalDateTime receivedAt;
}
