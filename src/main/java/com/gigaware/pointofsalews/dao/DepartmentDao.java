/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import com.gigaware.pointofsalews.dao.factory.GenericDao;
import com.gigaware.pointofsalews.entity.Department;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public interface DepartmentDao extends GenericDao<Department> {
	
	Department getDepartmentById( Long idDepartment );
	

}
