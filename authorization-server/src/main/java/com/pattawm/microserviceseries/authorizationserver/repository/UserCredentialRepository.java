package com.pattawm.microserviceseries.authorizationserver.repository;

import com.pattawm.microserviceseries.authorizationserver.repository.model.UserCredentialEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends CrudRepository<UserCredentialEntity,Long> {
    Optional<UserCredentialEntity> findByUsername(String username);
}
