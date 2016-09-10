/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import com.gigaware.pointofsalews.dao.factory.GenericDao;
import com.gigaware.pointofsalews.entity.SaleItem;
import java.util.List;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public interface SalesItemDao extends GenericDao<SaleItem>{
	
	List<SaleItem> getByInventoryLessThan( Float inventoryLessThan );
	
	SaleItem getByItemKey( String itemKey );
	SaleItem getByItemName( String itemName );
	SaleItem getByCodeBars( String codeBars );
	
	List<SaleItem> getDifferent( String itemName, String codeBars );

}