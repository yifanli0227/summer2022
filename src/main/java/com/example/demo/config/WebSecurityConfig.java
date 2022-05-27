package com.example.demo.config;

import javax.servlet.Filter;

import com.example.demo.handler.DeniedHandler;
import com.example.demo.handler.FailureHandler;
import com.example.demo.handler.SuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @Author 杨不易呀
 * web 安全的配置类
 * <p>
 * WebSecurityConfigurerAdapter   web安全配置的适配器
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
    private SuccessHandler successHandler;
	@Autowired
    private FailureHandler failureHandler;
    @Autowired
    private DeniedHandler deniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.exceptionHandling().accessDeniedHandler(deniedHandler);
        // 给一个表单登陆 就是我们的登录页面,登录成功或者失败后走我们的 url
        http.formLogin()
            .successHandler((req,res,authentication)
                -> successHandler.onAuthenticationSuccess(req, res, authentication))
            .failureHandler((req,res,authentication)
                -> failureHandler.onAuthenticationFailure(req, res, authentication));
         http.authorizeRequests()
            .antMatchers("admin").authenticated()
            .antMatchers(HttpMethod.POST, "/login").permitAll();;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

