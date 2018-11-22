package com.yrenh.museumsmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrenh.museumsmvc.dao.VisitorDao;
import com.yrenh.museumsmvc.entity.Visitor;
import com.yrenh.museumsmvc.service.VisitorService;

@Service
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	private VisitorDao visitorDao;
	
	@Override
	public void create(Visitor entity) {
		visitorDao.save(entity);
	}

	@Override
	public Visitor getById(Long id) {
		return visitorDao.find(id);
	}

	@Override
	public List<Visitor> getAll() {
		return visitorDao.getAll();
	}

	@Override
	public void update(Visitor entity) {
		visitorDao.update(entity);
	}

	@Override
	public void delete(Visitor entity) {
		visitorDao.delete(entity);
	}

}
