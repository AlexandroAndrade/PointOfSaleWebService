/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.sale.read;

import java.io.Serializable;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class SoldItemDetailsDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 1892751782205898656L;

	private String itemName;
	private Float quantity;
	private Float averageCost;
	private Float salePrice;
	private Float tax;
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName( String itemName ) {
		this.itemName = itemName;
	}
	
	public Float getQuantity() {
		return quantity;
	}
	
	public void setQuantity( Float quantity ) {
		this.quantity = quantity;
	}
	
	public Float getAverageCost() {
		return averageCost;
	}
	
	public void setAverageCost( Float averageCost ) {
		this.averageCost = averageCost;
	}
	
	public Float getSalePrice() {
		return salePrice;
	}
	
	public void setSalePrice( Float salePrice ) {
		this.salePrice = salePrice;
	}
	
	public Float getTax() {
		return tax;
	}
	
	public void setTax( Float tax ) {
		this.tax = tax;
	}
	
}
