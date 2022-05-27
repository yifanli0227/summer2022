package com.example.demo.mapper;

import com.example.demo.entity.SysUser;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
    int insertSysUser(SysUser sysUser);
 
    SysUser selectSysUser(@Param("username") String username);
}
