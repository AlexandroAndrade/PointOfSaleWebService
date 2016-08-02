/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class Branch extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 65529935346105746L;

	private Long idBranch;
	private String branchKey;
	private String branchName;
	private Set<Inventory> inventory = new HashSet<>();
	private Set<SaleTotal> sales = new HashSet<>();
	private Set<InventoryAdjustmentTotal> inventoryAdjustments = new HashSet<>();
	private Set<WareMovementTotal> wareMovements = new HashSet<>();

	public Long getIdBranch() {
		return idBranch;
	}

	public void setIdBranch( Long idBranch ) {
		this.idBranch = idBranch;
	}

	public String getBranchKey() {
		return branchKey;
	}

	public void setBranchKey( String branchKey ) {
		this.branchKey = branchKey;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName( String branchName ) {
		this.branchName = branchName;
	}

	public Set<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory( Set<Inventory> inventory ) {
		this.inventory = inventory;
	}

	public Set<SaleTotal> getSales() {
		return sales;
	}

	public void setSales( Set<SaleTotal> sales ) {
		this.sales = sales;
	}

	public Set<InventoryAdjustmentTotal> getInventoryAdjustments() {
		return inventoryAdjustments;
	}

	public void setInventoryAdjustments( Set<InventoryAdjustmentTotal> inventoryAdjustments ) {
		this.inventoryAdjustments = inventoryAdjustments;
	}

	public Set<WareMovementTotal> getWareMovements() {
		return wareMovements;
	}

	public void setWareMovements( Set<WareMovementTotal> wareMovements ) {
		this.wareMovements = wareMovements;
	}

}