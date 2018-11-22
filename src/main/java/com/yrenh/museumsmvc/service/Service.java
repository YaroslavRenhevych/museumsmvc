package com.yrenh.museumsmvc.service;

import java.util.List;

public interface Service<E> {
	
	void create(E entity);
	
	E getById(Long id);
	
	List<E> getAll();
	
	void update(E entity);
	
	void delete(E entity);
}
