package com.devkiu.order.command.api.event;

import com.devkiu.order.command.api.data.Order;
import com.devkiu.order.command.api.data.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventsHandler {
    private final OrderRepository orderRepository;
    @EventHandler
    public void on(OrderCreatedEvent event) {
        Order order = new Order();
        BeanUtils.copyProperties(event, order);
        orderRepository.save(order);
    }
}
