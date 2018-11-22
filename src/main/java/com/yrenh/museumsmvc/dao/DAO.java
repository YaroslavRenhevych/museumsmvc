package com.yrenh.museumsmvc.dao;

import java.util.List;

public interface DAO<E> {
	
	Long save(E entity);
	
	E find(Long id);
	
	void update(E entity);
	
	void delete(E entity);
	
	List<E> getAll();
}
