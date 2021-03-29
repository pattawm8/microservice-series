package com.pattawm.microserviceseries.authorizationserver.config.properties;

import lombok.Data;

import java.util.Set;

@Data
public class ClientProperties
{
    private Set<String> authorizedGrantTypes;
    private Set<String> scope;
}