/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import com.gigaware.pointofsalews.dao.factory.GenericDao;
import com.gigaware.pointofsalews.entity.Branch;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public interface BranchDao extends GenericDao<Branch> {
	
	Branch getByBranchName( String branchName );

}
