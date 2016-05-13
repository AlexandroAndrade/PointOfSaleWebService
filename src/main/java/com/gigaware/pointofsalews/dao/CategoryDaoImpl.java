/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gigaware.pointofsalews.constant.QueryConstants;
import com.gigaware.pointofsalews.dao.factory.AbstractHibernateDao;
import com.gigaware.pointofsalews.entity.Category;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Repository( "categoryDao" )
public class CategoryDaoImpl 
	extends AbstractHibernateDao
	implements CategoryDao, Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -5266861959532887438L;

	@Override
	public void save(Category t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void saveAll(List<Category> ts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Category t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getById(Long idCategory ) {
		return ( Category ) 
				super
					.createQuery( QueryConstants.CATEGORY_GET_BY_ID )
					.setParameter( "idCategory", idCategory )
					.uniqueResult();
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryByFatherId(Long fatherCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
