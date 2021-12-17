package com.company.reservation.controller;

import com.company.reservation.util.MessageResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends BaseController{
    @PostMapping("/login")
    public MessageResult login(@PathVariable String username, @PathVariable String password) {
        return success("Successfully signed in");
    }
}
