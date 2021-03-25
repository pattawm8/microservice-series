package com.pattawm.microserviceseries.shoppingcartservice.app.service.impl;

import com.pattawm.microserviceseries.shoppingcartservice.app.model.ProductOverview;
import com.pattawm.microserviceseries.shoppingcartservice.app.model.UserInfo;
import com.pattawm.microserviceseries.shoppingcartservice.app.service.AbstractRemoteService;
import com.pattawm.microserviceseries.shoppingcartservice.app.service.RemoteUserService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteUserServiceImpl extends AbstractRemoteService implements RemoteUserService {

    public RemoteUserServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public UserInfo getRemoteUserInfo(Long userId) {
        return getDataWithRestTemplate("http://" + USER_SERVICE_NAME + "/api/users/"+ userId, UserInfo.class);

    }
}
