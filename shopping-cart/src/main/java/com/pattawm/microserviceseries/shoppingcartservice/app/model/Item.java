package com.pattawm.microserviceseries.shoppingcartservice.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private ProductOverview product;
    private int quantity;

}