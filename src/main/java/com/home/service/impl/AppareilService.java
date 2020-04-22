package com.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.bean.Appareil;
import com.home.dao.IAppareilDao;
import com.home.service.IAppareilService;

@Service
public class AppareilService implements IAppareilService {
	
	@Autowired
	private IAppareilDao appareilDao;

	@Override
	public List<Appareil> getAppareils() {
		return appareilDao.findAll();
	}

	@Override
	public void saveAppareil(Appareil appareil) {
		appareilDao.save(appareil);
		
	}

	@Override
	public void delete(int id) {
		appareilDao.deleteById(id);
		
	}

}
