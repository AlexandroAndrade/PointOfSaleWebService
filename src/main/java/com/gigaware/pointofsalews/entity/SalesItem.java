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
public class SalesItem extends AbstractBaseEntity implements Serializable {
    
    /**
	 * AspectJ
	 */
	private static final long serialVersionUID = -9197884745195157740L;

    private Long idItem;
	private String itemKey;
    private String itemName;
    private Provider provider;
    private Department department;
    private String branch;
    private String codeBar;
  	private Float averageCost;
    private Float salePrice;
    private Set<Inventory> inventory = new HashSet<>();
    private Set<WareMovementDetail> saleItemMovements = new HashSet<>();
    
	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public String getItemKey() {
		return itemKey;
	}

	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCodeBar() {
		return codeBar;
	}

	public void setCodeBar(String codeBar) {
		this.codeBar = codeBar;
	}

	public Float getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(Float averageCost) {
		this.averageCost = averageCost;
	}

	public Float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

	public Set<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}

	public Set<WareMovementDetail> getSaleItemMovements() {
		return saleItemMovements;
	}

	public void setSaleItemMovements(Set<WareMovementDetail> saleItemMovements) {
		this.saleItemMovements = saleItemMovements;
	}

}