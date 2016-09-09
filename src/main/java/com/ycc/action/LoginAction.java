package com.ycc.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ycc.service.UserService;

public class LoginAction extends ActionSupport {
	private UserService userService;
	public UserService getUserService(){
		return userService;
	}
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	public String loginCheck(){
		return "error";
	}
}	
