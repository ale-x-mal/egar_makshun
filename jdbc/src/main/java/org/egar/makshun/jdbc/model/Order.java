package org.egar.makshun.jdbc.model;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Order {

    private Long id;
    private Float price;
    private Integer quantity;
    private Long userId;
    private Long deliveryTypeId;
    private Date orderDate;
}
