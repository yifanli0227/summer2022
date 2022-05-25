package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/dologin")
    @ResponseBody
    public String Operator(@RequestParam("username") String username,
                            @RequestParam("password") String password
                            ){
                                System.out.println("username: "+username+" password: "+password);
                                return username;
                            }
}
