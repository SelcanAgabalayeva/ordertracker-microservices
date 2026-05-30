package com.selcan.order_service.controller;
import com.selcan.order_service.dtos.CreateOrderRequest;
import com.selcan.order_service.dtos.OrderResponse;
import com.selcan.order_service.dtos.UpdateOrderRequest;
import com.selcan.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderResponse create(@RequestBody CreateOrderRequest request) {
        return orderService.create(request);
    }

    @GetMapping
    public List<OrderResponse> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderResponse getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PutMapping("/{id}/status")
    public OrderResponse updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateOrderRequest request
    ) {
        return orderService.updateStatus(id, request.getStatus());
    }
}
