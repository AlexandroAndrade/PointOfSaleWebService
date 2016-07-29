/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

//import com.gigaware.pointofsalews.constant.QueryConstants;
import com.gigaware.pointofsalews.dao.factory.AbstractHibernateDao;
import com.gigaware.pointofsalews.entity.Department;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Repository( "departmentDao" )
public class DepartmentDaoImpl 
	extends AbstractHibernateDao
	implements DepartmentDao, Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -5266861959532887438L;

	@Override
	public void save(Department t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void saveAll(List<Department> ts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Department t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department getById(Long idDepartment ) {
		return null;
//		return ( Department ) 
//				super
//					.createQuery( QueryConstants.CATEGORY_GET_BY_ID )
//					.setParameter( "idDepartment", idDepartment )
//					.uniqueResult();
	}

	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartmentById(Long idDepartment) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
