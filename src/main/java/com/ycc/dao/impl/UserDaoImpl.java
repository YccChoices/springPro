package com.ycc.dao.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ycc.dao.UserDao;
import com.ycc.model.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return new User();
	}

	@Override
	public void addUser(String name, String pwd) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		this.getHibernateTemplate().save(user);
	}

}
