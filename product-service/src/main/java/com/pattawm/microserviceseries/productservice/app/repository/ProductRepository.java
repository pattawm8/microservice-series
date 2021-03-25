package com.pattawm.microserviceseries.productservice.app.repository;

import com.pattawm.microserviceseries.productservice.app.repository.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Long> {
}
