/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import com.gigaware.pointofsalews.entity.SalesItem;
import com.gigaware.pointofsalews.service.factory.GenericService;
import java.util.List;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public interface SalesItemsService extends GenericService<SalesItem> {
    
	List<SalesItem> getByInventoryLessThan( Integer inventoryLessThan );
    
}
