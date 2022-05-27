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
     * 开启方法权限的注解
     *
     * @return
     */
    @GetMapping("add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String add() {
        return "欢迎来到主ADD";
    }

    @GetMapping("update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String update() {
        return "欢迎来到UPDATE";
    }

    @GetMapping("delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete() {
        return "欢迎来到DELETE";
    }

    @GetMapping("select")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String select() {
        return "欢迎来到SELECT";
    }

    @GetMapping("role")
    public String role() {
        return "欢迎来到ROLE";
    }


}



