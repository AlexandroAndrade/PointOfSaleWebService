/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.constant;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public final class QueryConstants {
    
	/**
	 * Sales Items Queries
	 */
    public static final String SALESITEM_GET_ALL =
            "SELECT SI FROM SaleItem SI " +  
            "JOIN FETCH SI.department "    +
            "JOIN FETCH SI.provider P ";
    
    public static final String SALESITEM_GET_BY_ID =
    		"SELECT SI FROM SaleItem SI " + 
    	    "WHERE SI.idItem in ( :idItem )";
    
    public static final String SALESITEM_GET_BY_INVENTORY_LESS_THAN = 
    		"SELECT SI FROM SaleItem SI " + 
    		"WHERE SI.inventory <= :inventory ";

}
