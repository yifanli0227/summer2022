package com.summer2022.model;

import java.io.Serializable;

public class AssignRoleRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String rolename;

	//need default constructor for JSON Parsing
	public AssignRoleRequest()
	{
		
	}

	public AssignRoleRequest(String username, String rolename) {
		this.setUsername(username);
		this.setRolename(rolename);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
