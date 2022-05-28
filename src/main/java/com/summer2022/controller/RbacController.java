package com.summer2022.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author Yifan Li
 */
@RestController
@CrossOrigin()
public class RbacController {

    /**
     * Login Success
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
     * Login failed
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


