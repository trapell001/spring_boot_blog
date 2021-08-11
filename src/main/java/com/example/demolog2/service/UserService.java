package com.example.demolog2.service;

import com.example.demolog2.model.request.user.UserAuthRequest;
import com.example.demolog2.model.request.user.UserSaveRequest;
import com.example.demolog2.model.response.user.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void save(UserSaveRequest userSaveRequest);
    UserResponse auth(UserAuthRequest userAuthRequest);
    UserResponse findById(long id);
    Page<UserResponse> getAll(Pageable pageable);
}
