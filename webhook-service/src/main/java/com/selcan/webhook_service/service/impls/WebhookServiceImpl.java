package com.selcan.webhook_service.service.impls;
import com.selcan.webhook_service.client.OrderClient;
import com.selcan.webhook_service.dto.PaymentWebhookRequest;
import com.selcan.webhook_service.dto.ShipmentWebhookRequest;
import com.selcan.webhook_service.dto.UpdateOrderRequest;
import com.selcan.webhook_service.model.WebhookLog;
import com.selcan.webhook_service.repository.WebhookLogRepository;
import com.selcan.webhook_service.service.WebhookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WebhookServiceImpl implements WebhookService {

    private final OrderClient orderClient;
    private final WebhookLogRepository logRepository;

    @Override
    public void handlePayment(PaymentWebhookRequest request) {

        saveLog("PAYMENT", request.toString());

        String status = request.getStatus().equals("SUCCESS")
                ? "PAID"
                : "FAILED";

        UpdateOrderRequest dto = new UpdateOrderRequest();
        dto.setStatus(status);

        orderClient.updateStatus(request.getOrderId(), dto);
    }

    @Override
    public void handleShipment(ShipmentWebhookRequest request) {

        saveLog("SHIPMENT", request.toString());

        UpdateOrderRequest dto = new UpdateOrderRequest();
        dto.setStatus(request.getStatus());

        orderClient.updateStatus(request.getOrderId(), dto);
    }

    private void saveLog(String type, String payload) {
        WebhookLog log = new WebhookLog();
        log.setEventType(type);
        log.setPayload(payload);
        log.setReceivedAt(LocalDateTime.now());

        logRepository.save(log);
    }
}
