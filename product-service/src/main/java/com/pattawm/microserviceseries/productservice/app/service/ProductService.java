package com.pattawm.microserviceseries.productservice.app.service;

import com.pattawm.microserviceseries.productservice.app.repository.model.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> findAllProduct();
    ProductEntity findById(Long productId);
}
