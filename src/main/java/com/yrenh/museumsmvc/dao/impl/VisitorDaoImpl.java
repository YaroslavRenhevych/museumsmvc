package com.yrenh.museumsmvc.dao.impl;

import com.yrenh.museumsmvc.dao.AbstractDao;
import com.yrenh.museumsmvc.dao.VisitorDao;
import com.yrenh.museumsmvc.entity.Visitor;

public class VisitorDaoImpl extends AbstractDao<Visitor> implements VisitorDao {
	
	public VisitorDaoImpl() {
		super(Visitor.class);
	}
	
}
