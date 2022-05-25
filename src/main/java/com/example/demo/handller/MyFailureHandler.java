package com.example.demo.handller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class MyFailureHandler implements AuthenticationFailureHandler {
    /**
     *
     * @param httpServletRequest Reueqst object
     * @param httpServletResponse  Response object
     * @param e  springsecurity框架验证用户信息成功后的封装类
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e
                                        ) throws IOException, ServletException {
       //Proceed if authtication fails
        httpServletResponse.setContentType("text/json;charset=utf-8");
        Result result = new Result();
        result.setCode(1);
        result.setError(1001);
        result.setMsg("login failed");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream,result);
        outputStream.flush();
        outputStream.close();

    }
}

