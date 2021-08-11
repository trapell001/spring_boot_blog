package com.example.demolog2.mapper.user;

import com.example.demolog2.entity.User;
import com.example.demolog2.mapper.Mapper;
import com.example.demolog2.model.request.user.UserSaveRequest;

@org.mapstruct.Mapper(componentModel = "spring")
public interface UserSaveMapper extends Mapper<User,UserSaveRequest> {
}
