package com.example.demolog2.model.request.user;

import lombok.Data;

@Data
public class UserAuthRequest {
    private String userName;
    private String password;
}
