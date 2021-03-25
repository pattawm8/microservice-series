package com.pattawm.microserviceseries.userservice.app.service.impl;

import com.pattawm.microserviceseries.userservice.app.repository.UserRepository;
import com.pattawm.microserviceseries.userservice.app.repository.model.UserEntity;
import com.pattawm.microserviceseries.userservice.app.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserEntity> findAllUser() {
        List<UserEntity> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
