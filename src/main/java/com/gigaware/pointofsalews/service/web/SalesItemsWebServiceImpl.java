/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import com.gigaware.pointofsalews.dto.SalesItemDto;
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
@Service( "salesItemsWebService" )
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

        final SalesItemWrapper wrapperResponse =
                new SalesItemWrapper();
        
        List<SalesItem> salesItems = salesItemsService.getAll();
        
        for(SalesItem si : salesItems){
        	SalesItemDto s = new SalesItemDto();
        	s.setIdSalesItem( si.getIdItem() );
        	s.setItemName( si.getItemName() );
        	s.setAverageCost( si.getAverageCost() );
        	s.setSalePrice( si.getSalePrice() );
        	s.setCodeBar( si.getCodeBar() );
        	s.setInventory( si.getInventory() );
        	s.setBranchName( si.getBranch().getBranchName() );
        	s.setProviderName( si.getProvider().getProviderName() );
        	wrapperResponse.getSalesItems().add(s);
        }
        return wrapperResponse;
    }

    /**
     * @param salesItemsService the salesItemsService to set
     */
    public void setSalesItemsService( SalesItemsService salesItemsService ) {
        this.salesItemsService = salesItemsService;
    }
    
    
     
    
}
