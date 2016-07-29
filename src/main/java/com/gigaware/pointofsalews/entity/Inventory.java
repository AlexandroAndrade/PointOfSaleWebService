/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;

/**
 * N to M relationship class
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class Inventory implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 7305928501070070318L;

	private SalesItem salesItem;
	private Branch branch;
	private Float inventory;
	
	public SalesItem getSalesItem() {
		return salesItem;
	}
	public void setSalesItem(SalesItem salesItem) {
		this.salesItem = salesItem;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Float getInventory() {
		return inventory;
	}
	public void setInventory(Float inventory) {
		this.inventory = inventory;
	}
	
	
	
	
}
