package com.yrenh.museumsmvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrenh.museumsmvc.dao.MuseumDao;
import com.yrenh.museumsmvc.entity.Museum;
import com.yrenh.museumsmvc.service.MuseumService;

@Service
@Transactional
public class MuseumServiceImpl implements MuseumService {

	@Autowired
	private MuseumDao museumDao;

	@Override
	public void create(Museum entity) {
		museumDao.save(entity);
	}

	@Override
	public Museum getById(Long id) {
		return museumDao.find(id);
	}

	@Override
	public List<Museum> getAll() {
		return museumDao.getAll();
	}

	@Override
	public void update(Museum entity) {
		museumDao.update(entity);
	}

	@Override
	public void delete(Museum entity) {
		museumDao.delete(entity);
	}

}
