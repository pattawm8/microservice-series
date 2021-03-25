package com.pattawm.microserviceseries.productservice.app.service.impl;

import com.pattawm.microserviceseries.productservice.app.repository.ProductRepository;
import com.pattawm.microserviceseries.productservice.app.repository.model.ProductEntity;
import com.pattawm.microserviceseries.productservice.app.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductEntity> findAllProduct() {
        List<ProductEntity> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public ProductEntity findById(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }
}
