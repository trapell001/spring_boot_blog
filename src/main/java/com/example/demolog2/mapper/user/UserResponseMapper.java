package com.example.demolog2.mapper.user;

import com.example.demolog2.entity.User;
import com.example.demolog2.mapper.Mapper;
import com.example.demolog2.model.response.user.UserResponse;
@org.mapstruct.Mapper(componentModel = "spring")
public interface UserResponseMapper extends Mapper<UserResponse,User> {
}
