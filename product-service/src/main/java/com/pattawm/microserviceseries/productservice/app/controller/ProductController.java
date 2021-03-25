package com.pattawm.microserviceseries.productservice.app.controller;

import com.pattawm.microserviceseries.productservice.app.repository.model.ProductEntity;
import com.pattawm.microserviceseries.productservice.app.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductEntity> findAll(){
        log.info("findAll product");
        return this.productService.findAllProduct();
    }

    @GetMapping("/{id}")
    public ProductEntity findById(@PathVariable Long id){
        log.info("findAll product");
        return this.productService.findById(id);
    }
}
