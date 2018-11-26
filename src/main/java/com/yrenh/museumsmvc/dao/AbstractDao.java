package com.yrenh.museumsmvc.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDao<E> implements DAO<E>{
	@PersistenceContext
	private EntityManager entityManager;
	private Class<E> clazz;
	
	public AbstractDao() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class<E>)type.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public E find(Long id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public void update(E entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(E entity) {
		entityManager.remove(entity);
	}

	@Override
	public List<E> getAll() {
		return entityManager.createQuery("SELECT entities FROM " + clazz.getName() + " entities", clazz)
					.getResultList();
	}
	
}
