package com.ycc.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ycc.dao.BaseDao;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao  {
	
	@Override
	public <T> void saveEntity(T entity) {
		// TODO Auto-generated method stub		
		this.getHibernateTemplate().saveOrUpdate(entity);		
	}

	@Override
	public <T> void deleteEntity(T entity) {
		// TODO Auto-generated method stub		
		this.getHibernateTemplate().delete(entity);	
	}

	@Override
	public <T> void updateEntity(T entity) {
		// TODO Auto-generated method stub		
		this.getHibernateTemplate().saveOrUpdate(entity);	
	}

	@Override
	public <T> List<T> getAllEntity( String  entityName) {
		// TODO Auto-generated method stub
		
		return (List<T>)this.getHibernateTemplate().find("from" +  " "+ entityName );
		
		//return (List<T>)this.hibernateTemplate.find("from Product");
	}

	@Override
	public <T> T getEntityById(Class<T> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}
	
	@Override
	public <T> void deleteEntityById(Class<T> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		
		this.getHibernateTemplate().delete( this.getEntityById(entityClass, id) );
		
	}
	
	@Override
	public <T> List<T> getbyPage(String hql, int pageNo, int pageSize ,int real ) {
		// TODO Auto-generated method stub	
		List<T> list = new ArrayList<T>();
		int begin =  (pageNo-1 )*pageSize;		
		int end =  (pageNo )*pageSize;	
		//分页显示可能存在bug
		
		/*if( real < 5 )
		{
			end =real;
		}
		else
		{
			if(real < end )
			{
				//end = real -1;
				
				end = real;
			}
			
		}*/
		
		//bug 修改显示bug
		if( end > real )
		{
			end = real;
		}
		list = (List<T>) this.getHibernateTemplate().find(hql).subList( begin , end );
		
		return list;
		

	}

	//实际页码
	@Override
	public <T> int realPage(String hql) {
		// TODO Auto-generated method stub		
		int count = 0;	
		count = this.getHibernateTemplate().find(hql).size();
		return count;
	}

}
