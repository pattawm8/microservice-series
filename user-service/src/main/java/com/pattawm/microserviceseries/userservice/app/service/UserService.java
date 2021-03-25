package com.pattawm.microserviceseries.userservice.app.service;

import com.pattawm.microserviceseries.userservice.app.repository.model.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAllUser();
    UserEntity findById(Long id);
}
