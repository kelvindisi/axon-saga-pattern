package com.devkiu.order.query.api.controller;

import com.devkiu.order.query.api.model.OrderResponseModel;
import com.devkiu.order.query.api.query.GetAllProductsRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderQueryController {
    private final QueryGateway queryGateway;

    @GetMapping
    public List<OrderResponseModel> getAllOrders() throws ExecutionException, InterruptedException {
        GetAllProductsRequest request = new GetAllProductsRequest();

        CompletableFuture<List<OrderResponseModel>> completableFuture = queryGateway.query(
                request,
                ResponseTypes.multipleInstancesOf(OrderResponseModel.class));

        return completableFuture.get();
    }
}
