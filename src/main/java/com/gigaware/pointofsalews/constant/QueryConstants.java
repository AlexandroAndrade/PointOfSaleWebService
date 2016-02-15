/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.constant;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public final class QueryConstants {
    
    public static final String SALESITEM_GET_ALL =
            "SELECT SI FROM SalesItem SI " + 
            "JOIN FETCH SI.branch B " + 
            "JOIN FETCH SI.provider P ";
    
}
