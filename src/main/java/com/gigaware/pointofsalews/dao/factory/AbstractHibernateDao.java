/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao.factory;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public abstract class AbstractHibernateDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public Query createQuery( final String query ){
        return getSessionFactory().getCurrentSession().createQuery( query );
    }

    /**
     * @return the sessionFactory
     */
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    protected void setSessionFactory( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
    }
    
    
}
