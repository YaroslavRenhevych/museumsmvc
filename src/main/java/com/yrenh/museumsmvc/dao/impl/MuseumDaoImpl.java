package com.yrenh.museumsmvc.dao.impl;

import com.yrenh.museumsmvc.dao.AbstractDao;
import com.yrenh.museumsmvc.dao.MuseumDao;
import com.yrenh.museumsmvc.entity.Museum;

public class MuseumDaoImpl extends AbstractDao<Museum> implements MuseumDao {
	
	public MuseumDaoImpl() {
		setClass(Museum.class);
	}
	
}
