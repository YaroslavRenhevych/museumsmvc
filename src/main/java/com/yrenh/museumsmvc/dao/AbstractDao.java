package com.yrenh.museumsmvc.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDao<E> implements DAO<E> {
	@PersistenceContext
	private EntityManager entityManager;
	private Class<E> clazz;
	private static final String GET_ALL_QUERY = "SELECT entities FROM %s entities";
	private static final int ENTITY_TYPE_INDEX = 0;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<E>) type.getActualTypeArguments()[ENTITY_TYPE_INDEX];
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
		return entityManager.createQuery(String.format(GET_ALL_QUERY, clazz.getName()), clazz).getResultList();
	}

}
