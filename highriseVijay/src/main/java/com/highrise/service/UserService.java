package com.highrise.service;

import com.highrise.model.User;

public interface UserService {

	void save(User user);
	void update(User user);
	void delete(User user);
	User findByStockCode(int userID);
}
