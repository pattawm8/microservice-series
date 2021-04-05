package com.pattawm.microserviceseries.authorizationserver.config.properties;

import lombok.Setter;

@Setter
public class JwtProperties
{
    private Integer accessToken;
    private Integer refreshToken;
    private final int defaultToken = 1800;

    public int getAccessToken()
    {
        if(accessToken == null || accessToken == 0){
            accessToken = defaultToken;
        }
        return accessToken;
    }

    public int getRefreshToken()
    {
        if(refreshToken == null || refreshToken == 0){
            refreshToken = defaultToken * 2;
        }
        return refreshToken;
    }
}