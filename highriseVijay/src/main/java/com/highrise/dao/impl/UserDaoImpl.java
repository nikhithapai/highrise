package com.highrise.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.highrise.connection.util.CustomHibernateDaoSupport;
import com.highrise.dao.UserDao;
import com.highrise.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends CustomHibernateDaoSupport implements UserDao {

	@Override
	public void save(User user) {
		getHibernateTemplate().save(user);
		
	}

	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
		
	}

	@Override
	public void delete(User user) {
		getHibernateTemplate().delete(user);
		
	}

	@Override
	public User findByStockCode(int userID) {
		List list = getHibernateTemplate().find(
                "from user where user_id=?",userID
           );
	return (User)list.get(0);
	}

}
