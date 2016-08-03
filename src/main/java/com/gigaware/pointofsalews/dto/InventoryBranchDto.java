/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto;

import java.io.Serializable;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class InventoryBranchDto implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 8974357270324603664L;
	
	private Float inventory;
	private String branchName;

	public Float getInventory() {
		return inventory;
	}

	public void setInventory(Float inventory) {
		this.inventory = inventory;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
