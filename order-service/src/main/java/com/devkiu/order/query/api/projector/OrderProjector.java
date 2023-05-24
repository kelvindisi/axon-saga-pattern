package com.devkiu.order.query.api.projector;

import com.devkiu.order.command.api.data.Order;
import com.devkiu.order.command.api.data.OrderRepository;
import com.devkiu.order.query.api.model.OrderResponseModel;
import com.devkiu.order.query.api.query.GetAllProductsRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderProjector {
    private final OrderRepository orderRepository;

    @QueryHandler
    public List<OrderResponseModel> on(GetAllProductsRequest request) {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(order -> {
            OrderResponseModel responseModel = new OrderResponseModel();
            BeanUtils.copyProperties(order, responseModel);
            return responseModel;
        }).collect(Collectors.toList());
    }
}
