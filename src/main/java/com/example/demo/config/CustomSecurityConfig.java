package com.example.demo.config;

import java.io.PrintWriter;

import com.example.demo.handller.MyFailureHandler;
import com.example.demo.handller.MySuccessHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Autowired 
    private MyFailureHandler failureHandler;
    @Autowired 
    private MySuccessHandler successHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/index").permitAll()   //No auth required
                .antMatchers("/access/user").hasRole("USER")
                .antMatchers("/access/admin").hasRole("ADMIN")
                .antMatchers("/access/read").hasRole("READ")
                .anyRequest().authenticated()   //Auth required
                .and()
                .formLogin()
                //  .loginPage("/ajaxlogin").permitAll()   //customize login page
                //  .loginProcessingUrl("/dologin")  //customize uri form


                .successHandler((req,res,authentication)
                 -> successHandler.onAuthenticationSuccess(req, res, authentication))
                .failureHandler((req,res,authentication)
                -> failureHandler.onAuthenticationFailure(req, res, authentication))
        ;
    }
 
 
}

