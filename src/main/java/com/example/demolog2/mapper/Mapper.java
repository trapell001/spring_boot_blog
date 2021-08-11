package com.example.demolog2.mapper;

import com.example.demolog2.entity.User;
import com.example.demolog2.model.request.user.UserSaveRequest;

import java.util.List;
import java.util.Set;

public interface Mapper<S, D> {
    S to(D obj);

    D from(S obj);

    List<S> to(List<D> entities);

    List<D> from(List<S> dtos);

    Set<S> to(Set<D> entities);

    Set<D> from(Set<S> dtos);
}
