/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import com.gigaware.pointofsalews.service.SalesItemsService;
import com.gigaware.pointofsalews.wrapper.SalesItemWrapper;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "salesItemsWebService" )
public class SalesItemsWebServiceImpl 
    implements SalesItemWebService, Serializable {
    
    @Autowired
    private SalesItemsService salesItemsService;
    
    @Override
    public SalesItemWrapper getAllSalesItems() {

        final SalesItemWrapper wrapperResponse =
                new SalesItemWrapper();
        
        wrapperResponse.setSalesItems( salesItemsService.getAll() );
        return wrapperResponse;
    }

    /**
     * @param salesItemsService the salesItemsService to set
     */
    public void setSalesItemsService( SalesItemsService salesItemsService ) {
        this.salesItemsService = salesItemsService;
    }
    
    
     
    
}
