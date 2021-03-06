package com.pattawm.microserviceseries.shoppingcartservice.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ItemDTO {

    private Long productId;
    private String productName;
    private int quantity;

}