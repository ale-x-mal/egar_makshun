package org.egar.makshun.jdbc.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Basket {

    private Long id;
    private Byte discount;
    private Long userId;
}
