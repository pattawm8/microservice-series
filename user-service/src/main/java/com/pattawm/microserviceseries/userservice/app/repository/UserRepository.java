package com.pattawm.microserviceseries.userservice.app.repository;

import com.pattawm.microserviceseries.userservice.app.repository.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
