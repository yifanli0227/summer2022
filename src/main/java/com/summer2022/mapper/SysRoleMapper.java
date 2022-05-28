package com.summer2022.mapper;

import java.util.List;

import com.summer2022.entity.SysRole;

import org.springframework.stereotype.Repository;

/**
 * @Author Yifan Li
 * Mapper for roles from table sys_role
 * 
 */

@Repository
public interface SysRoleMapper {
    List<SysRole> selectSysRoleByUserId(Integer userId);
}
