/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import com.gigaware.pointofsalews.dto.SalesItemDto;
import com.gigaware.pointofsalews.dto.create.SalesItemCreateModifyDTO;
import com.gigaware.pointofsalews.entity.SalesItem;
import com.gigaware.pointofsalews.service.SalesItemsService;
import com.gigaware.pointofsalews.wrapper.SalesItemWrapper;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "salesItemWebService" )
public class SalesItemsWebServiceImpl 
    implements SalesItemWebService, Serializable {
	
    /**
	 * AspectJ 
	 */
	private static final long serialVersionUID = -4682711023351630779L;

	@Autowired
    private SalesItemsService salesItemsService;
	
    @Override
    public SalesItemWrapper getAllSalesItems() {
    	return populateSalesItemWrapper( salesItemsService.getAll() );
    }

	@Override
	public SalesItemDto getItemById( Long idItem ) {
		SalesItem item = salesItemsService.getById( idItem );
		SalesItemDto itemDto = new SalesItemDto( item );
		return itemDto;
	}
	
	@Override
	public SalesItemWrapper getByInventoryLessThan( Integer inventory ) {
		return populateSalesItemWrapper(salesItemsService.getByInventoryLessThan(inventory));
	}
	
	@Override
	public SalesItemWrapper saveItem(SalesItemCreateModifyDTO item) {
		System.out.println("Item: " + item.toString() );
		return null;
	}
	
	private SalesItemWrapper populateSalesItemWrapper( List<SalesItem> items ){
		SalesItemWrapper wrapper = new SalesItemWrapper();
		for( SalesItem si : items){
			SalesItemDto dto = new SalesItemDto( si );
			wrapper.getSalesItems().add( dto );
		}
		return wrapper;
	}
	
    /**
     * @param salesItemsService the salesItemsService to set
     */
    public void setSalesItemsService( SalesItemsService salesItemsService ) {
        this.salesItemsService = salesItemsService;
    }

}