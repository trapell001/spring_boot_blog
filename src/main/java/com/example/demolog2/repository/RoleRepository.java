package com.example.demolog2.repository;

import com.example.demolog2.entity.Role;

import java.util.List;

public interface RoleRepository extends BaseRepository<Role,Long> {
    List<Role> findByIdIn(List<Long> ids);
}
