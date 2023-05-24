package com.devkiu.order.command.api.controller;

import com.devkiu.order.command.api.command.CreateOrderCommand;
import com.devkiu.order.command.api.model.OrderRequestModel;
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
public class OrderCommandController {
    private final CommandGateway commandGateway;
    @PostMapping
    public String createOrder(@RequestBody OrderRequestModel orderRequestModel) {
        CreateOrderCommand createOrderCommand = CreateOrderCommand
                .builder()
                .orderId(UUID.randomUUID().toString())
                .addressId(orderRequestModel.getAddressId())
                .productId(orderRequestModel.getProductId())
                .quantity(orderRequestModel.getQuantity())
                .userId(orderRequestModel.getUserId())
                .status("CREATED")
                .build();
        return commandGateway.sendAndWait(createOrderCommand);
    }
}
