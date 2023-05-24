package com.devkiu.order.query.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseModel {
    private String orderId;
    private String productId;
    private Integer quantity;
    private String addressId;
    private String userId;
    private String status;
}
