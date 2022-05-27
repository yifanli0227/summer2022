package com.example.demo.config;

import com.example.demo.handler.DeniedHandler;
import com.example.demo.handler.FailureHandler;
import com.example.demo.handler.SuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author 杨不易呀
 * web 安全的配置类
 * <p>
 * WebSecurityConfigurerAdapter   web安全配置的适配器
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{


    /**
     * 配置认证(用户)管理 模拟内存用户数据
	* 重点说明：
	* 在开发中，我们一般只针对权限，很少去使用角色
	* 后面的讲解中我们以权限为主也就是 authorities 这里面的东西
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中创建了两个用户
        auth.inMemoryAuthentication()
                .withUser("yby") // 用户名
                .password(passwordEncoder().encode("yby"))
                .roles("ADMIN","USER") // 给了一个角色

                // 测试用户 只有一个查看权限
                .and()
                .withUser("test")
                .password(passwordEncoder().encode("test"))
                .roles("USER")

                // admin用户 角色权限区分
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN") // 注意点：不能带入前缀ROLE_ security里面默认会添加的 最终结果是  ROLE_ADMIN
        ;
    }


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

        // 匹配哪些 url，需要哪些权限才可以访问 当然我们也可以使用链式编程的方式
        // http.authorizeRequests()
        //     .antMatchers("/query").hasAuthority("sys:query") // 表示这个用户有这个权限标识才能访问
        //     .antMatchers("/select").hasAuthority("sys:select")
        //     .antMatchers("/del").hasAuthority("sys:del")
        //     .antMatchers("/update").hasAuthority("sys:update")
        //     .antMatchers("/admin/**").hasRole("ADMIN") // 表示这个用户有这个角色才能访问
        ; // 其他所有的请求都需要登录才能进行
        // 所有的请求都需要认证才可以访问
        http.authorizeRequests().anyRequest().authenticated();
    }
    


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

