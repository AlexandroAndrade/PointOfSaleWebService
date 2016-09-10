/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import com.gigaware.pointofsalews.dto.create.SalesItemCreateDTO;
import com.gigaware.pointofsalews.dto.create.SalesItemUpdateDTO;
import com.gigaware.pointofsalews.entity.SaleItem;
import com.gigaware.pointofsalews.service.factory.GenericService;
import java.util.List;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public interface SalesItemsService 
	extends GenericService<SaleItem, SalesItemCreateDTO, SalesItemUpdateDTO> {
    
	List<SaleItem> getByInventoryLessThan( Integer inventoryLessThan );
	SaleItem getByItemKey( String itemKey );
    
}