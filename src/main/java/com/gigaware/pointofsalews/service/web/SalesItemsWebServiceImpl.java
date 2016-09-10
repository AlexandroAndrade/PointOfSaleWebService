/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import com.gigaware.pointofsalews.dto.SalesItemDto;
import com.gigaware.pointofsalews.dto.create.SalesItemCreateDTO;
import com.gigaware.pointofsalews.dto.create.SalesItemUpdateDTO;
import com.gigaware.pointofsalews.entity.SaleItem;
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
		SaleItem item = salesItemsService.getById( idItem );
		SalesItemDto itemDto = new SalesItemDto( item );
		return itemDto;
	}
	
	@Override
	public SalesItemDto getItemByItemKey( String itemKey ) {
		SaleItem item = salesItemsService.getByItemKey( itemKey );
		SalesItemDto itemDto = new SalesItemDto( item );
		return itemDto;
	}
	
	@Override
	public SalesItemWrapper getByInventoryLessThan( Integer inventory ) {
		return populateSalesItemWrapper(salesItemsService.getByInventoryLessThan(inventory));
	}
	
	@Override
	public SalesItemWrapper saveItem(SalesItemCreateDTO saleItem) {
		SaleItem persistedSaleItem = salesItemsService.save( saleItem );
		SalesItemDto itemDto = new SalesItemDto( persistedSaleItem );
		SalesItemWrapper responseWrapper = new SalesItemWrapper();
		responseWrapper.getSalesItems().add( itemDto );
		return responseWrapper;
	}
	
	@Override
	public SalesItemWrapper updateItem( SalesItemUpdateDTO saleItem ) {
		SaleItem updatedSaleItem = salesItemsService.update( saleItem );
		SalesItemDto itemDTO = new SalesItemDto( updatedSaleItem );
		SalesItemWrapper responseWrapper = new SalesItemWrapper();
		responseWrapper.getSalesItems().add( itemDTO );
		return responseWrapper;
	}
	
	@Override
	public SalesItemDto deleteItem( Long idItem ) {
		SaleItem deletedSaleItem = salesItemsService.delete( idItem );
		SalesItemDto itemDTO = new SalesItemDto( deletedSaleItem );
		return itemDTO;
	}
	
	private SalesItemWrapper populateSalesItemWrapper( List<SaleItem> items ){
		SalesItemWrapper wrapper = new SalesItemWrapper();
		for( SaleItem si : items){
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