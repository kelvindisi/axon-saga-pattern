package com.devkiu.order.command.api.controller;

import com.devkiu.order.command.api.command.CreateOrderCommand;
import com.devkiu.order.command.api.model.ProductRequestModel;
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
    public String addNewProduct(@RequestBody ProductRequestModel productRequestModel) {
        CreateOrderCommand createOrderCommand = CreateOrderCommand
                .builder()
                .orderId(UUID.randomUUID().toString())
                .productId(productRequestModel.getProductId())
                .addressId(productRequestModel.getAddressId())
                .quantity(productRequestModel.getQuantity())
                .userId(productRequestModel.getUserId())
                .build();
        return commandGateway.sendAndWait(createOrderCommand);
    }
}
