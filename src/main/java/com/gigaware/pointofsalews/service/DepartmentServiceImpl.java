/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gigaware.pointofsalews.dao.DepartmentDao;
import com.gigaware.pointofsalews.entity.Department;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "departmentService" )
@Transactional
public class DepartmentServiceImpl implements DepartmentService, Serializable {
	
	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 874760201485905098L;
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getById( Long idCategory ) {
		return departmentDao.getById( idCategory );
	}

	@Override
	public void save( Department t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll( List<Department> ts ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update( Department t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete( Department t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department getDepartmentById( Long idDepartment ) {
		// TODO Auto-generated method stub
		return null;
	}

}
