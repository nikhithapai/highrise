package com.highrise.dao;

import org.springframework.transaction.annotation.Transactional;

import com.highrise.model.User;

@Transactional
public interface UserDao {

	void save(User user);

	void update(User user);

	void delete(User user);

	User findByStockCode(int userID);

}
