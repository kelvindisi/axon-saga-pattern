package com.devkiu.order.command.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class ProductRequestModel {
    private String productId;
    private String userId;
    private String addressId;
    private String quantity;
}
