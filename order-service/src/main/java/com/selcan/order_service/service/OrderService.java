package com.selcan.order_service.service;


import com.selcan.order_service.dtos.CreateOrderRequest;
import com.selcan.order_service.dtos.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse create(CreateOrderRequest request);

    List<OrderResponse> getAll();

    OrderResponse getById(Long id);

    OrderResponse updateStatus(Long id, String status);
}
