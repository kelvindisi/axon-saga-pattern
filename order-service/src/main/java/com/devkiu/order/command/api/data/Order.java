package com.devkiu.order.command.api.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    @Column(name = "id")
    private String orderId;
    private String productId;
    private Integer quantity;
    private String addressId;
    private String userId;
    private String status;
}
