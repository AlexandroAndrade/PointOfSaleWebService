/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "sucursal" )
public class Branch extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 65529935346105746L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "idSucursal", nullable = false )
	private Long idBranch;
	
	@Column( name = "claveSucursal", nullable = false )
	private String branchKey;
	
	@Column( name = "nombreSucursal", nullable = false )
	private String branchName;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "branch" )
	private Set<Inventory> inventory = new HashSet<>();
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "branch" )
	private Set<SaleTotal> sales = new HashSet<>();
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "branch" )
	private Set<InventoryAdjustmentTotal> inventoryAdjustments = new HashSet<>();
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "branch" )
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