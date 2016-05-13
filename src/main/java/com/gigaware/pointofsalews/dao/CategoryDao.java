/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import com.gigaware.pointofsalews.dao.factory.GenericDao;
import com.gigaware.pointofsalews.entity.Category;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public interface CategoryDao extends GenericDao<Category> {
	
	Category getCategoryByFatherId( Long fatherCategoryId );
	

}
