package com.summer2022.entity;

/**
 * @Author Yifan Li
 * Role Entity retrived from database
 * 
 */

public class SysRole {
    private Integer id;
    private String rolename;
    private String rolememo;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getRolename() {
        return rolename;
    }
 
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
 
    public String getRolememo() {
        return rolememo;
    }
 
    public void setRolememo(String rolememo) {
        this.rolememo = rolememo;
    }
 
    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", rolememo='" + rolememo + '\'' +
                '}';
    }
}

