package com.ycc.service;

import com.ycc.model.User;

public interface UserService {
	public User getUser(String name,String pwd);
	public void addUser(String name,String pwd);
}
