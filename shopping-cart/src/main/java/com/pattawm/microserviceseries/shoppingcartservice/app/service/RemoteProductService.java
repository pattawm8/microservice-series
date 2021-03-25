package com.pattawm.microserviceseries.shoppingcartservice.app.service;

import com.pattawm.microserviceseries.shoppingcartservice.app.model.ProductOverview;

public interface RemoteProductService {
    ProductOverview getRemoteProductItemsInfo(Long productId);
}
