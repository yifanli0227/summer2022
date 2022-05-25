package com.example.demo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.demo.entity.SysUser;
import com.example.demo.mapper.SysUserMapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@MapperScan(value = "com.example.demo.mapper")   //扫描mapper文件

public class DemoApplication 
{
    @Autowired
    SysUserMapper userMapper;
    public static void main( String[] args )
    {
        SpringApplication.run(DemoApplication.class,args);
 
    }

    
    //Following part is used to initialze sys_user table.

    /*
    @PostConstruct 
    public void jdbcInit(){
        Date curDate = new Date(0);
        List<GrantedAuthority> list = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+"ADMIN");
        list.add(authority);
        
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        SysUser sysUser = new SysUser(
                1,"demo1",encoder.encode("11111"),"demoo3o",
                true,true,true,true,curDate,curDate);
        userMapper.insertSysUser(sysUser);


        Date curDate1 = new Date(0);
        List<GrantedAuthority> list1 = new ArrayList<>();
        GrantedAuthority authority1 = new SimpleGrantedAuthority("ROLE_"+"READ");
        list1.add(authority1);
        
        PasswordEncoder encoder1 = new BCryptPasswordEncoder();
        SysUser sysUser1 = new SysUser(
                1,"demo2",encoder1.encode("22222"),"demoo3o",
                true,true,true,true,curDate1,curDate1);
        userMapper.insertSysUser(sysUser1);


        Date curDate2 = new Date(0);
        List<GrantedAuthority> list2 = new ArrayList<>();
        GrantedAuthority authority2 = new SimpleGrantedAuthority("ROLE_"+"USER");
        list2.add(authority2);
        
        PasswordEncoder encoder2 = new BCryptPasswordEncoder();
        SysUser sysUser2 = new SysUser(
                1,"demo3",encoder2.encode("33333"),"demoo3o",
                true,true,true,true,curDate2,curDate2);
        userMapper.insertSysUser(sysUser2);
    }
    */
}


