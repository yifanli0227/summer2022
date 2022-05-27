package com.example.demo.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @Author 杨不易呀
 */
@RestController
public class AuthorityController {

    /**
     * 登录成功的主页返回值
     *
     * @return
     */
    @PostMapping("welcome")
    public String welcome() {
        return "欢迎来到主页";
    }

    // @PostMapping("login")
    // public String login(){
    //     return "You are at login.";
    // }

    /**
     * 登录失败的返回值
     *
     * @return
     */
    @PostMapping("fail")
    public String fail() {
        return "登录失败了";
    }

    /**
     * Access Control
     *
     * @return
     */
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String add() {
        return "You have admin access";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String update() {
        return "You have user access";
    }

    @GetMapping("/reader")
    @PreAuthorize("hasRole('ROLE_READER')")
    public String delete() {
        return "You are only reader";
    }
}



