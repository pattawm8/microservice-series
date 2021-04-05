package com.pattawm.microserviceseries.shoppingcartservice.app.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@AllArgsConstructor
@Slf4j
public abstract class AbstractRemoteService {
    protected final String USER_SERVICE_NAME = "USER-SERVICE";
    protected final String PRODUCT_SERVICE_NAME = "PRODUCT-SERVICE";

    private final RestTemplate restTemplate;

    protected <T> T getDataWithRestTemplate(String url, Class<T> clazz) {
        return getDataWithRestTemplate(url, MediaType.APPLICATION_JSON, null, clazz);
    }

    protected <T> T postDataWithRestTemplate(String url, String body, Class<T> clazz) {
        return postDataWithRestTemplate(url, body, MediaType.APPLICATION_JSON, null, clazz);
    }

    protected <T> T getDataWithRestTemplate(String url, MediaType contentType, HttpHeaders httpHeaders, Class<T> clazz) {
        log.info("######### {} | Call Service URL : {} #########", this.getClass().getName(), url);
        HttpEntity<String> httpEntity = this.setHttpEntity(null, contentType, httpHeaders);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, clazz);
        log.info("######### {} | Response Service URL : {} Response : {} #########", this.getClass().getName(), url, responseEntity);
        return responseEntity.getBody();
    }

    protected <T> T postDataWithRestTemplate(String url,String body, MediaType contentType, HttpHeaders httpHeaders, Class<T> clazz) {
        log.info("######### {} | Call Service URL : {} , Body : {} #########", this.getClass().getName(), url, body);
        HttpEntity<String> httpEntity = this.setHttpEntity(body, contentType, httpHeaders);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, clazz);
        log.info("######### {} | Response Service URL : {} Response : {} #########", this.getClass().getName(), url, responseEntity);
        return responseEntity.getBody();
    }

    private HttpEntity<String> setHttpEntity(String parameter, MediaType contentType, HttpHeaders httpHeaders){
        HttpHeaders headers = httpHeaders;
        if(headers == null) {
            headers = new HttpHeaders();
        }

        String token = this.getBearerTokenHeader();
        log.info("token : {}",token);
        headers.add("Authorization", token);

        if(contentType != null) {
            headers.setContentType(contentType);
        }
        return new HttpEntity<>(parameter, headers);
    }

    private String getBearerTokenHeader() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }
}
