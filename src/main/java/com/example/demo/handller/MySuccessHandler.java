package com.example.demo.handller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class MySuccessHandler implements AuthenticationSuccessHandler {
    /**
     *
     * @param httpServletRequest    Request
     * @param httpServletResponse   Response
     * @param authentication        springsecurity框架验证用户信息成功后的封装类
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, 
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication
                                        ) throws IOException, ServletException {
        //After successful authenticaiton
        httpServletResponse.setContentType("text/json;charset=utf-8");
        Result result = new Result();
        result.setCode(0);
        result.setError(1000);
        result.setMsg("Login Success");
        result.setAjax(authentication.getPrincipal());                                    
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream,result);
        outputStream.flush();
        outputStream.close();

    }
}
