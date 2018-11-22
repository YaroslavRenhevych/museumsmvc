package com.yrenh.museumsmvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrenh.museumsmvc.dao.PictureDao;
import com.yrenh.museumsmvc.entity.Picture;
import com.yrenh.museumsmvc.service.PictureService;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureDao pictureDao;
	
	@Override
	public void create(Picture entity) {
		pictureDao.save(entity);
	}

	@Override
	public Picture getById(Long id) {
		return pictureDao.find(id);
	}

	@Override
	public List<Picture> getAll() {
		return pictureDao.getAll();
	}

	@Override
	public void update(Picture entity) {
		pictureDao.update(entity);
	}

	@Override
	public void delete(Picture entity) {
		pictureDao.delete(entity);
	}

}
