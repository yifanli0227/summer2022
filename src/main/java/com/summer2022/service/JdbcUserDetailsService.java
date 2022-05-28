package com.summer2022.service;

import java.util.ArrayList;
import java.util.List;

import com.summer2022.entity.SysRole;
import com.summer2022.entity.SysUser;
import com.summer2022.mapper.SysRoleMapper;
import com.summer2022.mapper.SysUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author Yifan Li
 * Customized Database Interface
 * <p>
 * To retrive user and its roles with given username
 */

 @Service
public class JdbcUserDetailsService implements UserDetailsService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 1. Get user info base on username provided
        SysUser sysUser = sysUserMapper.selectSysUser(s);
        if(sysUser != null ){
            // System.out.println("User found: "+sysUser.toString());
            // 2.Get role info based on user id
            List<SysRole> sysRoles = sysRoleMapper.selectSysRoleByUserId(sysUser.getId());
            // System.out.println(sysRoles.toString());
            List<GrantedAuthority> authorities = new ArrayList<>();
            sysRoles.stream().forEach((e)->{
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+e.getRolename());
                authorities.add(authority);
            });
            sysUser.setAuthorities(authorities);
            return sysUser;
        }else{
            throw new 
            UsernameNotFoundException("User not exist with name: " + s);
        }
    }
}

