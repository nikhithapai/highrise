package com.highrise.connection.util;

import org.hibernate.SessionFactory;
//import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;
//import org.hibernate.*;
//import org.springframework.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

 

public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport{

	@Autowired
    public void connectionFactory(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
	
	
	/* protected Session getSession(SessionFactory sessionFactory)
             throws DataAccessResourceFailureException {

	Session session = super.getSession(sessionFactory);
    session.setFlushMode(FlushMode.COMMIT);    
    return session;
	 }
	 protected void closeSession(Session session, SessionFactory factory) {
	        session.flush();  
	        super.closeSession(session, factory);  
	    }*/
}
