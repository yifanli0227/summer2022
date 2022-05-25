package com.example.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/ajaxlogin")
    public String toAjaxHtml(){
        return "forward:/ajaxlogin.html";
    } 
}
