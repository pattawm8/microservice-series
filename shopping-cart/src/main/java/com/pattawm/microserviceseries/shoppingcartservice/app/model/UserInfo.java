package com.pattawm.microserviceseries.shoppingcartservice.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String address;

}