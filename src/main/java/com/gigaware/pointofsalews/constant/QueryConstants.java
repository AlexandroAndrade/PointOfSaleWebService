/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.constant;

import com.gigaware.pointofsalews.entity.Branch;
import com.gigaware.pointofsalews.entity.Department;
import com.gigaware.pointofsalews.entity.Provider;
import com.gigaware.pointofsalews.entity.SaleItem;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public final class QueryConstants {
    
	/**
	 * Query Constants for {@link SaleItem} Entity
	 */
    public static final String SALESITEM_GET_ALL =
            "SELECT DISTINCT SI FROM SaleItem SI " +
            "JOIN FETCH SI.department D " +
            "JOIN FETCH SI.provider P   " +
            "JOIN FETCH SI.inventory I "  +
            "JOIN FETCH I.branch B "      ; 
    
    public static final String SALESITEM_GET_BY_ID =
    		"SELECT SI FROM SaleItem SI " + 
    		"JOIN FETCH SI.department D " +
    		"JOIN FETCH SI.provider P "   +
            "JOIN FETCH SI.inventory I "  +
            "JOIN FETCH I.branch B "      + 
    	    "WHERE SI.idItem in ( :idItem )";
    
    public static final String SALESITEM_GET_BY_ITEMKEY = 
    		"SELECT SI FROM SaleItem SI " + 
    		"WHERE SI.itemKey in ( :itemKey ) ";

    public static final String SALESITEM_GET_BY_ITEMNAME = 
    		"SELECT SI FROM SaleItem SI " + 
    		"WHERE SI.itemName in ( :itemName ) ";

    public static final String SALESITEM_GET_BY_CODBARS = 
    		"SELECT SI FROM SaleItem SI " + 
    		"WHERE SI.codeBars in ( :codeBars ) ";

    public static final String SALESITEM_GET_BY_INVENTORY_LESS_THAN = 
    		"SELECT SI FROM SaleItem SI " + 
    		"WHERE SI.inventory <= :inventory ";

	/**
	 * Query Constants for {@link Branch} Entity
	 */
    public static final String BRANCH_GET_ALL = 
    		"SELECT B FROM Branch B " ;

    public static final String BRANCH_GET_BY_ID = 
    		"SELECT B FROM Branch B " + 
    		"WHERE B.idBranch in ( :idBranch ) " ;

	/**
	 * Query Constants for {@link Department} Entity
	 */
    public static final String DEPARTMENT_GET_ALL = 
    		"SELECT D FROM Department D " ;

    public static final String DEPARTMENT_GET_BY_ID = 
    		"SELECT D FROM Department D " + 
    		"WHERE D.idDepartment in ( :idDepartment ) ";
    
    /**
     * Query Constants for {@link Provider} Entity
     */
    public static final String PROVIDER_GET_ALL = 
    		"SELECT P FROM Provider P " ;

    public static final String PROVIDER_GET_BY_ID = 
    		"SELECT P FROM Provider P " + 
    		"WHERE P.idProvider in ( :idProvider ) ";

}
