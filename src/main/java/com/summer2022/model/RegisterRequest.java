package com.summer2022.model;

import java.io.Serializable;

public class RegisterRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	private String realname;

	//need default constructor for JSON Parsing
	public RegisterRequest()
	{
		
	}

	public RegisterRequest(String username, String password, String realname) {
		this.setUsername(username);
		this.setPassword(password);
        this.setrealname(realname);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getrealname(){
        return this.realname;
    }

    public void setrealname(String realname){
        this.realname = realname;
    }
}