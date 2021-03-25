package com.pattawm.microserviceseries.userservice.app.controller;

import com.pattawm.microserviceseries.userservice.app.repository.model.UserEntity;
import com.pattawm.microserviceseries.userservice.app.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserEntity> findAll(){
        log.info("findAll user");
        return this.userService.findAllUser();
    }

    @GetMapping("/{id}")
    public UserEntity findById(@PathVariable Long id){
        log.info("findByUserId");
        return this.userService.findById(id);
    }
}
