package com.pattawm.microserviceseries.shoppingcartservice.app.service.impl;

import com.pattawm.microserviceseries.shoppingcartservice.app.model.ProductOverview;
import com.pattawm.microserviceseries.shoppingcartservice.app.service.AbstractRemoteService;
import com.pattawm.microserviceseries.shoppingcartservice.app.service.RemoteProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteProductServiceImpl extends AbstractRemoteService implements RemoteProductService {

    public RemoteProductServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public ProductOverview getRemoteProductItemsInfo(Long productId) {
        return getDataWithRestTemplate("http://" + PRODUCT_SERVICE_NAME + "/api/products/"+ productId, ProductOverview.class);
    }
}
