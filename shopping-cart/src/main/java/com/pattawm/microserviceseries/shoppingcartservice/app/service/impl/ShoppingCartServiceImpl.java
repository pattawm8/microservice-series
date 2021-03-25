package com.pattawm.microserviceseries.shoppingcartservice.app.service.impl;

import com.pattawm.microserviceseries.shoppingcartservice.app.model.Cart;
import com.pattawm.microserviceseries.shoppingcartservice.app.model.UserInfo;
import com.pattawm.microserviceseries.shoppingcartservice.app.service.RemoteProductService;
import com.pattawm.microserviceseries.shoppingcartservice.app.service.RemoteUserService;
import com.pattawm.microserviceseries.shoppingcartservice.app.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final RemoteProductService remoteProductService;
    private final RemoteUserService remoteUserService;

    @Override
    public Cart purchase(Cart shoppingCart) {
        log.info("begin purchase");
        var uuid = UUID.randomUUID().toString();
        shoppingCart.setId(uuid);

        var user = this.remoteUserService.getRemoteUserInfo(shoppingCart.getUser().getId());
        shoppingCart.setUser(user);

        shoppingCart.getItems().forEach(item -> {
            var product = this.remoteProductService.getRemoteProductItemsInfo(item.getProduct().getId());
            item.setProduct(product);
        });

        log.info("end purchase");
        return shoppingCart;
    }
}
