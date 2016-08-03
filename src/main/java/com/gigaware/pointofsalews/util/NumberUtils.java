/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.util;

/**
 * Utilities for Numbers 
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
*/
public final class NumberUtils {
	
	
	private NumberUtils(){}
	
	/**
	 * Validates if the provided Long object is positive
	 * nulls and <= 0 are false
	 * @param i - object to validate
	 * @return true if positive, false otherwise
	 */
	public static boolean isPositive( Long i ){
		return i != null && i > 0L ;
	}
	
	/**
	 * Validates if the provided Float object is positive
	 * nulls and <= 0 are false
	 * @param i - object to validate
	 * @return true if positive, false otherwise
	 */
	public static boolean isPositive( Float i ){
		return i != null && i > 0L ;
	}

}
