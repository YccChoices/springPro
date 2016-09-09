package com.ycc.dao;

import java.util.List;

import com.ycc.model.User;

public interface UserDao {
	public User getUser(String name,String pwd);
	public void addUser(String name,String pwd);
}
