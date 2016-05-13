/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import com.gigaware.pointofsalews.entity.Category;
import com.gigaware.pointofsalews.service.factory.GenericService;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public interface CategoryService extends GenericService<Category> {
	
	Category getCategoryByFatherId( Long idFatherCategory );
	

}
