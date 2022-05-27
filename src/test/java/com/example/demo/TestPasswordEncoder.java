package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPasswordEncoder {
    public static void main(String[] args) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encode1 = passwordEncoder.encode("123");
    System.out.println(encode1);
    String encode2 = passwordEncoder.encode("123");
    System.out.println(encode2);
    String encode3 = passwordEncoder.encode("123");
    System.out.println(encode3);
    // 查看加密后是否匹配
    System.out.println(passwordEncoder.matches("123", encode1));
    System.out.println(passwordEncoder.matches("123", encode2));
    System.out.println(passwordEncoder.matches("123", encode3));
    }
    }
    