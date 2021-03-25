package com.pattawm.microserviceseries.shoppingcartservice.app.service;

import com.pattawm.microserviceseries.shoppingcartservice.app.model.UserInfo;

public interface RemoteUserService {
    UserInfo getRemoteUserInfo(Long userId);
}
