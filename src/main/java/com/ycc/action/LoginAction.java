package com.ycc.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

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
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		if(userService.getUser(name, pwd)!=null){
			return SUCCESS;
		}else return "index";
	}
}	
