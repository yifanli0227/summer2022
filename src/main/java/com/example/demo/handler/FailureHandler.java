package com.example.demo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @Author 杨不易呀
 * 自定义登录成功的处理器
 * 返回json
 */
@Configuration
public class FailureHandler implements AuthenticationFailureHandler {


    /**
     * 登陆成功后执行的处理器
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception
                                        ) throws IOException, ServletException {
        System.out.println("登录成功了");
        // 把json串写出去
        response.setContentType("application/json;charset=utf-8");
        HashMap<String, Object> map = new HashMap<>(8);
        System.out.println(exception);
        map.put("code", 401);
        map.put("msg", "登录失败");
        // 把用户信息返回给前端 让前端可以保存起来
        // map.put("data", exception);
        if (exception instanceof LockedException) {
            map.put("msg", "账户被锁定，登陆失败！");
        } else if (exception instanceof BadCredentialsException) {
            map.put("msg", "账户或者密码错误，登陆失败！");
        } else if (exception instanceof DisabledException) {
            map.put("msg", "账户被禁用，登陆失败！");
        } else if (exception instanceof AccountExpiredException) {
            map.put("msg", "账户已过期，登陆失败！");
        } else if (exception instanceof CredentialsExpiredException) {
            map.put("msg", "密码已过期，登陆失败！");
        } else {
            map.put("msg", "登陆失败！");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(map);
        // 写出去
        PrintWriter writer = response.getWriter();
        writer.write(s);
        // 刷新流 关闭流
        writer.flush();
        writer.close();
    }
}

