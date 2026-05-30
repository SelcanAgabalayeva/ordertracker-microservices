package com.selcan.webhook_service.client;

import com.selcan.webhook_service.dto.OrderResponse;
import com.selcan.webhook_service.dto.UpdateOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "order-service")
public interface OrderClient {

    @PutMapping("/api/orders/{id}/status")
    OrderResponse updateStatus(@PathVariable("id") Long id,
                               @RequestBody UpdateOrderRequest request);
}
