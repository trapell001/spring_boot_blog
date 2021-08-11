package com.example.demolog2.service.impl;

import com.example.demolog2.entity.Role;
import com.example.demolog2.entity.User;
import com.example.demolog2.exception.ObjectNotFoundException;
import com.example.demolog2.mapper.user.UserResponseMapper;
import com.example.demolog2.mapper.user.UserSaveMapper;
import com.example.demolog2.model.request.user.UserAuthRequest;
import com.example.demolog2.model.request.user.UserSaveRequest;
import com.example.demolog2.model.response.user.UserResponse;
import com.example.demolog2.repository.RoleRepository;
import com.example.demolog2.repository.UserRepository;
import com.example.demolog2.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserSaveMapper userSaveMapper;
    private final UserResponseMapper userResponseMapper;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           UserSaveMapper userSaveMapper, UserResponseMapper userResponseMapper, RoleRepository repository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userSaveMapper = userSaveMapper;
        this.userResponseMapper = userResponseMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(UserSaveRequest userSaveRequest) {
        User user = userSaveMapper.to(userSaveRequest);
        Set<Role> roles = new HashSet<>(roleRepository.findByIdIn(userSaveRequest.getRoleIds()));
        user.setRoles(roles);
         userRepository.save(user);
    }
    @Override
    public UserResponse auth(UserAuthRequest userAuthRequest) {
        User user = userRepository.findByUserNameAndPassword(userAuthRequest.getUserName(),userAuthRequest.getPassword());
        return userResponseMapper.to(user);
    }

    @Override
    public UserResponse findById(long id) {
        Optional<User> user=userRepository.findById(id);
        //get: nếu ko tìm thấy id bắn ra ngoại lệ
        user.orElseThrow(()-> new ObjectNotFoundException("user not found"));
        return userResponseMapper.to(user.get());
    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable.previousOrFirst());
        return users.map(userResponseMapper::to);
    }
}
