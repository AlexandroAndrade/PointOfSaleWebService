/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.exception;

/**
* @author Alex Andrade ( yngwie_alex@hotmail.com )
*/
public final class ExceptionConstant {

	private ExceptionConstant(){}
	
	private static final String IS_LOGICAL_DELETED = "Is Logical Deleted ?";
	
	/**
	 * Constant Exception Messages for Sales Items
	 */
	public static final String SALES_ITEM_NOT_FOUND_TITLE = 
			"Sale Item Not Found";
	
	public static final String SALES_ITEM_ALREADY_EXISTS_TITLE = 
			"Sale Item already Exists";
	
	public static final String SALES_ITEM_NOT_FOUND_BY_ID_DESCRIPTON = 
			"No Sale Item found for Id = [%d]. ";
	
	public static final String SALES_ITEM_NOT_FOUND_BY_ITEM_KEY = 
			"No Sale Item found for Item Key = [%s]. ";
	
	public static final String SALES_ITEM_ALREADY_EXISTS_BY_ITEM_KEY = 
			"Sale Item with Key [%s] already exists!. " + IS_LOGICAL_DELETED;

	public static final String SALES_ITEM_ALREADY_EXISTS_BY_ITEM_NAME = 
			"Sale Item with Name [%s] already exists! . " + IS_LOGICAL_DELETED;

	public static final String SALES_ITEM_ALREADY_EXISTS_BY_CODE_BARS = 
			"Sale Item with Code Bars [%s] already exists!. " + IS_LOGICAL_DELETED;
	
	public static final String SALES_ITEM_ALREADY_EXISTS_DIFFERENT = 
			"One or More Sale Items already exist for Item Name [ %s ] and Code Bars [ %s ]. " + IS_LOGICAL_DELETED;

	
	/**
	 * Constant Messages for Empty Values
	 */
	public static final String EMPTY_REQUIRED_FIELD = 
			"Required Field is Empty";
	
	public static final String SALES_ITEM_EMPTY_VALUE_ITEM_ID = 
			"Required field [ idItem ] is Empty";
	
	public static final String SALES_ITEM_EMPTY_VALUE_ITEM_BRAND = 
			"Required field [ brand ] is Empty";

	public static final String SALES_ITEM_EMPTY_VALUE_ITEM_KEY = 
			"Required field [ itemKey ] is Empty";
	
	public static final String SALES_ITEM_EMPTY_VALUE_ITEM_NAME =
			"Required field [ itemName ] is Empty";
	
	public static final String SALES_ITEM_EMPTY_VALUE_ITEM_CODE_BARS = 
			"Required field [ codeBars ] is Empty";

	public static final String SALES_ITEM_EMPTY_VALUE_ITEM_DEPARTMENT_ID = 
			"Required field [ idDepartment ] is Empty";

	public static final String SALES_ITEM_EMPTY_VALUE_ITEM_PROVIDER_ID = 
			"Required field [ idProvider ] is Empty";
	
	public static final String SALES_ITEM_EMPTY_NUMERIC_VALUE_ITEM_SALE_PRICE = 
			"Required Numeric Value [ salePrice ] must be Positive and Not Empty";
	
	
	/**
	 * Constant Exception Messages for Department
	 */
	public static final String DEPARTMENT_NOT_FOUND_TITLE = "Department not Found";
	
	public static final String DEPARTMENT_NOT_FOUND_BY_ID_DESCRIPTON = 
			"No Department found for Id = [%d]. ";

	/**
	 * Constant Exception Messages for Provider
	 */
	public static final String PROVIDER_NOT_FOUND_TITLE = "Provider not Found";
	
	public static final String PROVIDER_NOT_FOUND_BY_ID_DESCRIPTON = 
			"No Provider found for Id = [%d]. ";

	

}
