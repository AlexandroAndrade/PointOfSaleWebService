/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gigaware.pointofsalews.constant.QueryConstants;
import com.gigaware.pointofsalews.dao.factory.AbstractHibernateDao;
import com.gigaware.pointofsalews.entity.Provider;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Repository( "providerDao" )
public class ProviderDaoImpl extends AbstractHibernateDao implements ProviderDao, Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -3068347712073930581L;
	
	@Override
	public Provider getById( Long idProvider ) {
		return (Provider)
				super.createQuery( QueryConstants.PROVIDER_GET_BY_ID )
					 .setParameter( "idProvider", idProvider )
					 .uniqueResult();
	}
	
	@Override
	@SuppressWarnings( "unchecked" )
	public List<Provider> getAll() {
		return super.createQuery( QueryConstants.PROVIDER_GET_ALL ).list();
	}

	@Override
	public void save( Provider t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll( List<Provider> ts ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update( Provider t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete( Provider t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Provider getByProviderName( String providerName ) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
