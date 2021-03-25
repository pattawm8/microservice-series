package com.pattawm.microserviceseries.shoppingcartservice.app.service;

import com.pattawm.microserviceseries.shoppingcartservice.app.model.Cart;

public interface ShoppingCartService {
    Cart purchase(Cart shoppingCart);
}
