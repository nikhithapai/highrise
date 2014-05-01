package com.highrise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highrise.dao.UserDao;
import com.highrise.model.User;
import com.highrise.service.UserService;

@Service("userBO")
public class UserServiceImpl implements UserService {

	@Autowired UserDao userDao;
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByStockCode(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	 
 

}
