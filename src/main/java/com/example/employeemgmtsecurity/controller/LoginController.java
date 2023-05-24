package com.example.employeemgmtsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/myLogin")
    public String myLogin() {
        return "login.jsp";
    }

}
