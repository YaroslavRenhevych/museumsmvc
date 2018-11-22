package com.yrenh.museumsmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao<E> implements DAO<E>{
	@Autowired
	private SessionFactory sessionFactory;
	private Class<E> clazz;
	
	public AbstractDao(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Long save(E entity) {
		return (Long)getSession().save(entity);
	}

	@Override
	public E find(Long id) {
		return getSession().get(clazz, id);
	}

	@Override
	public void update(E entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(E entity) {
		getSession().delete(entity);
	}

	@Override
	public List<E> getAll() {
		return getSession().createQuery("from " + clazz.getName(), clazz).list();
	}
	
	
}
