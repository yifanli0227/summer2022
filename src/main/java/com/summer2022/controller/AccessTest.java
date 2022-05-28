package com.summer2022.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Yifan Li
 */
@RestController
@CrossOrigin()
public class AccessTest {

    /**
     * Access Test
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
    @PreAuthorize("hasRole('ROLE_READ')")
    public String delete() {
        return "You are only reader";
    }
}


