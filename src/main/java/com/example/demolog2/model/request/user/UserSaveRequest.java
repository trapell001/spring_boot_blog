package com.example.demolog2.model.request.user;

import lombok.Data;

import java.util.List;

@Data
public class UserSaveRequest {
    private String userName;
    private String password;
    private String address;
    private String phone;
    private String email;
    private String name;
    private List<Long> roleIds;
}
