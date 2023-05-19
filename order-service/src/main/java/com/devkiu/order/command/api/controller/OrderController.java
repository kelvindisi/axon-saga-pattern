package com.devkiu.order.command.api.controller;

import com.devkiu.order.command.api.command.CreateOrderCommand;
import com.devkiu.order.command.api.model.OrderRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final CommandGateway commandGateway;
    @PostMapping
    public String createOrder(@RequestBody OrderRestModel orderRestModel) {
        CreateOrderCommand createOrderCommand = CreateOrderCommand
                .builder()
                .orderId(UUID.randomUUID().toString())
                .addressId(orderRestModel.getAddressId())
                .userId(orderRestModel.getUserId())
                .productId(orderRestModel.getProductId())
                .quantity(orderRestModel.getQuantity())
                .build();
        return commandGateway.sendAndWait(createOrderCommand);
    }
}
