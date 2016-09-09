package com.ycc.service;

import com.ycc.model.User;

public interface UserService {
	public User getUserById();
	public void addUser(String name,String pwd);
}
