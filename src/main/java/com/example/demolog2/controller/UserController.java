package com.example.demolog2.controller;

import com.example.demolog2.model.request.user.UserAuthRequest;
import com.example.demolog2.model.request.user.UserSaveRequest;
import com.example.demolog2.model.response.user.UserResponse;
import com.example.demolog2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<Void> save(@RequestBody UserSaveRequest userSaveRequest){
        userService.save(userSaveRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PostMapping("/user/auth")
    public ResponseEntity<UserResponse> auth(@RequestBody UserAuthRequest userAuthRequest){
        UserResponse userResponse = userService.auth(userAuthRequest);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable long id){
        UserResponse userResponse = userService.findById(id);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<Page<UserResponse>> getAll(@RequestParam int index,
                                                     @RequestParam int size){
        PageRequest pageRequest = PageRequest.of(index,size);
        Page<UserResponse> userResponses = userService.getAll(pageRequest);
        return new ResponseEntity<>(userResponses,HttpStatus.OK);
    }
    @GetMapping("/reg")
    public String reg(Model model){
        model.addAttribute("userSaveRequest" , new UserSaveRequest());
        return "reg";
    }
    @PostMapping("/reg")
    public String reg(@ModelAttribute UserSaveRequest userSaveRequest){
        userService.save(userSaveRequest);
        return "index";
    }
}
