package com.summer2022.mapper;

import com.summer2022.entity.SysUser;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Yifan Li
 * Mapper for users from table sys_user
 * 
 */

@Repository
public interface SysUserMapper {
    int insertSysUser(SysUser sysUser);
 
    SysUser selectSysUser(@Param("username") String username);
}
