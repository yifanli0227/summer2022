package com.example.demo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @Author Yifan Li
 * Customized AccessDeniedHandler
 * return json
 */
@Configuration
public class DeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException exception) throws IOException, ServletException {
                System.out.println("无权限");
                // 把json串写出去
                response.setContentType("application/json;charset=utf-8");
                HashMap<String, Object> map = new HashMap<>(8);
                map.put("code", 403);
                map.put("msg", "Access Denied");
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


