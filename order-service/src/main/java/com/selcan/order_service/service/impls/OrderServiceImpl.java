package com.selcan.order_service.service.impls;

import com.selcan.order_service.dtos.CreateOrderRequest;
import com.selcan.order_service.dtos.OrderResponse;
import com.selcan.order_service.exceptions.NotFoundException;
import com.selcan.order_service.model.Order;
import com.selcan.order_service.model.OrderStatus;
import com.selcan.order_service.repositories.OrderRepository;
import com.selcan.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponse create(CreateOrderRequest request) {

        Order order = new Order();
        order.setProductName(request.getProductName());
        order.setAmount(request.getAmount());
        order.setCustomerEmail(request.getCustomerEmail());
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());

        Order saved = orderRepository.save(order);

        return mapToResponse(saved);
    }

    @Override
    public List<OrderResponse> getAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found: " + id));

        return mapToResponse(order);
    }

    @Override
    public OrderResponse updateStatus(Long id, String status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found: " + id));

        order.setStatus(OrderStatus.valueOf(status));

        return mapToResponse(orderRepository.save(order));
    }

    private OrderResponse mapToResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getProductName(),
                order.getAmount(),
                order.getStatus().name(),
                order.getCustomerEmail()
        );
    }
}
