package com.selcan.webhook_service.repository;

import com.selcan.webhook_service.model.WebhookLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebhookLogRepository extends JpaRepository<WebhookLog, Long> {
}
