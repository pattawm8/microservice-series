package com.pattawm.microserviceseries.shoppingcartservice.app.controller;

import com.pattawm.microserviceseries.shoppingcartservice.app.mapper.CartMapper;
import com.pattawm.microserviceseries.shoppingcartservice.app.model.dto.ShoppingCartRequestDTO;
import com.pattawm.microserviceseries.shoppingcartservice.app.model.dto.ShoppingCartResponseDTO;
import com.pattawm.microserviceseries.shoppingcartservice.app.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/cart")
@Slf4j
@AllArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService service;
    private CartMapper mapper;

    @PostMapping
    public ResponseEntity<ShoppingCartResponseDTO> submit(@RequestBody ShoppingCartRequestDTO requestDTO) {
        var cart = mapper.toModel(requestDTO);
        cart = service.purchase(cart);
        var responseDTO = mapper.toResponseDTO(cart);
        return ResponseEntity.created(URI.create(responseDTO.getId())).body(responseDTO);
    }
}
