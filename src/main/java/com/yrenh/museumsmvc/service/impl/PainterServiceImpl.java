package com.yrenh.museumsmvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrenh.museumsmvc.dao.PainterDao;
import com.yrenh.museumsmvc.entity.Painter;
import com.yrenh.museumsmvc.service.PainterService;

@Service
@Transactional
public class PainterServiceImpl implements PainterService {

	@Autowired
	private PainterDao painterDao;

	@Override
	public void create(Painter entity) {
		painterDao.save(entity);
	}

	@Override
	public Painter getById(Long id) {
		return painterDao.find(id);
	}

	@Override
	public List<Painter> getAll() {
		return painterDao.getAll();
	}

	@Override
	public void update(Painter entity) {
		painterDao.update(entity);
	}

	@Override
	public void delete(Painter entity) {
		painterDao.delete(entity);
	}

}
