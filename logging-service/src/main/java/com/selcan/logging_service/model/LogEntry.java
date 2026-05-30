package com.selcan.logging_service.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;   // order-service, webhook-service
    private String eventType;     // ORDER_CREATED, PAYMENT_SUCCESS
    private String level;         // INFO, ERROR, WARN

    @Lob
    private String message;

    private LocalDateTime timestamp;
}
