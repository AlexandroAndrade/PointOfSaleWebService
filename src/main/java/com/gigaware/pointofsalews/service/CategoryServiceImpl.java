/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gigaware.pointofsalews.dao.CategoryDao;
import com.gigaware.pointofsalews.entity.Category;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "categoryService" )
@Transactional
public class CategoryServiceImpl implements CategoryService, Serializable {
	
	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 874760201485905098L;
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getById( Long idCategory ) {
		return categoryDao.getById( idCategory );
	}

	@Override
	public void save( Category t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll( List<Category> ts ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update( Category t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete( Category t ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getCategoryByFatherId( Long idFatherCategory ) {
		// TODO Auto-generated method stub
		return null;
	}

}
