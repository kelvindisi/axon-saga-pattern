package com.devkiu.order.command.api.saga;

import com.devkiu.order.command.api.event.OrderCreatedEvent;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

@Saga
public class OrderProcessingSaga {
    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void on(OrderCreatedEvent event) {

    }
}
