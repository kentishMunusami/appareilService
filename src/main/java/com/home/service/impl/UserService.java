package com.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.bean.User;
import com.home.dao.IUserDao;
import com.home.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public void saveUser(User user) {
		userDao.save(user);
		
	}

}
