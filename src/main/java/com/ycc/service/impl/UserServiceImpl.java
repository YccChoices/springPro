package com.ycc.service.impl;

import com.ycc.dao.UserDao;
import com.ycc.model.User;
import com.ycc.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public UserDao getUserDao(){
		return this.userDao;
	}
	public void setUserDao(UserDao dao){
		this.userDao = dao;
	}
	@Override
	public User getUserById() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}
	@Override
	public void addUser(String name, String pwd) {
		// TODO Auto-generated method stub
		userDao.addUser(name, pwd);
	}

}
