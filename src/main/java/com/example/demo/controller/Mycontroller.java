package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
    @GetMapping(value = "/access/user")
    public String sayUser(){
        return "user role";
    }
 
    @GetMapping(value = "/access/admin")
    public String sayAdmin(){
        return "admin role";
    }
 
    @GetMapping(value = "/access/read")
    public String sayRead(){
        return "read role";
    }

}

