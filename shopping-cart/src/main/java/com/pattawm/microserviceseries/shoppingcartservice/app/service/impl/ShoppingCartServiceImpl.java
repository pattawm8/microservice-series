package com.pattawm.microserviceseries.shoppingcartservice.app.service.impl;

import com.pattawm.microserviceseries.shoppingcartservice.app.model.Cart;
import com.pattawm.microserviceseries.shoppingcartservice.app.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Override
    public Cart purchase(Cart shoppingCart) {
        log.info("begin purchase");
        var uuid = UUID.randomUUID().toString();
        shoppingCart.setId(uuid);
        return shoppingCart;
    }
}
