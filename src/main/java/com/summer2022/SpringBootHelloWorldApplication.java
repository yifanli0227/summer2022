package com.summer2022;

import com.summer2022.mapper.SysUserMapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.summer2022.mapper")   //扫描mapper文件
public class SpringBootHelloWorldApplication {

	@Autowired
    SysUserMapper userMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}
}