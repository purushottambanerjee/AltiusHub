package com.example.demo.Controller;


import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserService service;
    @Autowired
    public UserController(UserService userService){
        this.service = userService;
    }


    // Set the User Details
    @PostMapping("/register")
    public String RegisterUser(@RequestBody  User user)
    {
       return service.RegisterUser(user);
    }
    //Login the User
    @PostMapping("/Login")
    public String LoginUser(@RequestBody User user){
        return service.LoginUser(user.getId(), user.getPassword());
    }
    @GetMapping("/healthcheck")
    public String Test(){
        return "Service is Up";
    }



}
