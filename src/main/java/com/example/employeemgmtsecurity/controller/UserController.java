package com.example.employeemgmtsecurity.controller;

import com.example.employeemgmtsecurity.model.UserInfo;
import com.example.employeemgmtsecurity.repo.UserRepository;
import com.example.employeemgmtsecurity.service.teacherservice.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo){
        String password=userInfo.getPassword();
        String encodedPassword=passwordEncoder.encode(password);
        userInfo.setPassword(encodedPassword);
        userRepository.save(userInfo);
        return "User added successfully";
    }
    @GetMapping("/helloAll")
    public String helloAll(){
        return "HelloAll";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/helloAdminAndUser")
    public String helloAdminAndUser(){
        return "Hello Admin and User";
    }
}
