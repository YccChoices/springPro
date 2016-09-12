package com.ycc.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ycc.service.ProductService;
import com.ycc.service.UserService;

public class TestUser {
	//测试初始配置sessionFactory是否得到代理对象
	@Test
	public void testSessionFactory(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
	}
	//测试是否操作数据库以及代理服务及spring事务管理
	@Test
	public void testAddUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) context.getBean("userService");
		System.out.println(service);
		service.addUser("aa", "bbb");
	}
	//测试能否登录用
	@Test
	public void testgetUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) context.getBean("userService");
		System.out.println(service);
		service.getUser("ycc", "123");
	}
	@Test
	public void tsetProductService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = (ProductService) context.getBean("productService");
		System.out.println("productService"+productService.maxSize());
	}
}
