package com.summer2022.controller;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.summer2022.entity.JSONResult;
import com.summer2022.entity.SysUser;
import com.summer2022.mapper.SysUserMapper;
import com.summer2022.model.AssignRoleRequest;
import com.summer2022.model.RegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@TableName("SysUser")
public class UserManagerment {

    @Autowired
    SysUserMapper userMapper;
    
    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userRegister(@RequestBody RegisterRequest regRequest)
    throws Exception {
        Date curDate = new Date(System.currentTimeMillis());
        String username = regRequest.getUsername();
        String password = regRequest.getPassword();
        String realname = regRequest.getrealname();
 
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return JSONResult.fillResultString(406,"Username or Password cnanot be empty!","");
        }
        UserDetails oldUser = userDetailsService.loadUserByUsername(username);
        if (oldUser != null){
            return JSONResult.fillResultString(400, "Username taken!", "");
        }else{
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            System.out.print("reached register final");
            SysUser sysUser = new SysUser(
                        1,username,encoder.encode(password),realname,
                        true,true,true,true,curDate,curDate); 
            userMapper.insertSysUser(sysUser);
            return JSONResult.fillResultString(200, "User Registered", "");
        }
    }  
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/assignRole", method = RequestMethod.POST)
    public String assignRole(@RequestBody AssignRoleRequest roleRequest)
    throws Exception {
        
        String username = roleRequest.getUsername();
        String rolename = roleRequest.getRolename();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(rolename)) {
            return JSONResult.fillResultString(406,"Username or rolename cannot be empty!","");
        }
        UserDetails oldUser = userDetailsService.loadUserByUsername(username);
        if (oldUser == null){
            return JSONResult.fillResultString(400, "User Not Found!", "");
        }else{ 
            SysUser sysUser = sysUserMapper.selectSysUser(username);
            if(rolename.matches("ADMIN")){
                userMapper.assignRole(sysUser.getId(), 1);
            }else{
                userMapper.assignRole(sysUser.getId(), 2);
            }

            return JSONResult.fillResultString(200, "Role(s) assigned!", "");

        }
    }
}
