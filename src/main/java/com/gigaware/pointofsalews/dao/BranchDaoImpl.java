/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gigaware.pointofsalews.constant.QueryConstants;
import com.gigaware.pointofsalews.dao.factory.AbstractHibernateDao;
import com.gigaware.pointofsalews.entity.Branch;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Repository( "branchDao" )
public class BranchDaoImpl extends AbstractHibernateDao implements BranchDao, Serializable {
	
	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 6676326070979476274L;

	@Override
	public Branch getById( Long idBranch ) {
		return (Branch) 
				super.createQuery( QueryConstants.BRANCH_GET_BY_ID )
					 .setParameter( "idBranch", idBranch )
					 .uniqueResult();
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public List<Branch> getAll() {
		return super.createQuery( QueryConstants.BRANCH_GET_ALL ).list();
	}

	
	@Override
	public void save( Branch t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll( List<Branch> ts ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update( Branch t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete( Branch t ) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Branch getByBranchName( String branchName ) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
