package com.devkiu.order.command.api.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private String productId;
    private String userId;
    private String addressId;
    private String quantity;
}
