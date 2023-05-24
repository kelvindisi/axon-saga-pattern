package com.devkiu.order.command.api.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderRequestModel {
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
}
