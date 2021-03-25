package com.pattawm.microserviceseries.shoppingcartservice.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOverview implements Serializable {

    private Long id;
    private String name;
    private BigDecimal price;


    public BigDecimal getPrice() {
        if (price == null)
            price = BigDecimal.ZERO;
        return price;
    }

}