/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import com.gigaware.pointofsalews.entity.Department;
import com.gigaware.pointofsalews.service.factory.GenericService;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public interface DepartmentService extends GenericService<Department> {
	
	Department getDepartmentById( Long idDepartment );
	

}
