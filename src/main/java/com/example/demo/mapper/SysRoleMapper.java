package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.SysRole;

import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMapper {
    List<SysRole> selectSysRoleByUserId(Integer userId);
}