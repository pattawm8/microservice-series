package com.pattawm.microserviceseries.authorizationserver.config.service;

import com.pattawm.microserviceseries.authorizationserver.config.model.Client;
import com.pattawm.microserviceseries.authorizationserver.config.properties.SecurityProperties;
import com.pattawm.microserviceseries.authorizationserver.repository.UserCredentialRepository;
import com.pattawm.microserviceseries.authorizationserver.repository.model.UserCredentialEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CustomClientDetailsService implements ClientDetailsService {

    private final SecurityProperties securityProperties;
    private final UserCredentialRepository userCredentialRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        log.debug("loadClientByClientId");

        Optional<UserCredentialEntity> userCredential = this.userCredentialRepository.findByUsername(clientId);
        if(userCredential.isEmpty()){
            log.info("clientId = {} not found",clientId);
            throw new ClientRegistrationException("clientId " + clientId + " not found");
        }

        return this.buildClient(userCredential.get());
    }

    private Client buildClient(UserCredentialEntity userCredential){
        Client client = new Client();
        client.setClientId(userCredential.getUsername());
        client.setClientSecret(userCredential.getPassword());
        client.setAuthorizedGrantTypes(securityProperties.getClient().getAuthorizedGrantTypes());
        client.setScope(securityProperties.getClient().getScope());
        client.setAccessTokenValiditySeconds(securityProperties.getJwt().getAccessToken());
        client.setRefreshTokenValiditySeconds(securityProperties.getJwt().getRefreshToken());
        return client;
    }
}
