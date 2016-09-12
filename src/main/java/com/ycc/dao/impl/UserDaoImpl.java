package com.ycc.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ycc.dao.UserDao;
import com.ycc.model.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getUser(String name,String pwd) {
		// TODO Auto-generated method stub
		String queryString = "from User as u where u.name='"+name+"' and u.pwd='"+pwd+"'";    
		List list = this.getHibernateTemplate().find(queryString);
		if(list.size()==1){
			User user = (User) list.get(0);
			return user;
		}else return null;
	}

	@Override
	public void addUser(String name, String pwd) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName(name);
//		user.setPwd(pwd);
		this.getHibernateTemplate().save(user);
	}

}
