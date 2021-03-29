package com.pattawm.microserviceseries.authorizationserver.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="custom.authentication")
public class SecurityProperties
{
    private JwtProperties jwt;
    private ClientProperties client;
}