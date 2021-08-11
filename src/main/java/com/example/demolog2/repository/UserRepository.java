package com.example.demolog2.repository;

import com.example.demolog2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends BaseRepository<User,Long> {
    User findByUserNameAndPassword(String userName, String password);
}   
