/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class InventoryAdjustmentTotal extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 728980412820740749L;
	
	private Long idInventoryAdjustmentTotal;
	private User user;
	private Branch branch;
	private Date adjustmentDate;
	private Float totalSurplus;
	private Float totalLoss;
	private Set<InventoryAdjustmentDetail> inventoryDetails = new HashSet<>();
	public Long getIdInventoryAdjustmentTotal() {
		return idInventoryAdjustmentTotal;
	}
	public void setIdInventoryAdjustmentTotal(Long idInventoryAdjustmentTotal) {
		this.idInventoryAdjustmentTotal = idInventoryAdjustmentTotal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Date getAdjustmentDate() {
		return adjustmentDate;
	}
	public void setAdjustmentDate(Date adjustmentDate) {
		this.adjustmentDate = adjustmentDate;
	}
	public Float getTotalSurplus() {
		return totalSurplus;
	}
	public void setTotalSurplus(Float totalSurplus) {
		this.totalSurplus = totalSurplus;
	}
	public Float getTotalLoss() {
		return totalLoss;
	}
	public void setTotalLoss(Float totalLoss) {
		this.totalLoss = totalLoss;
	}
	public Set<InventoryAdjustmentDetail> getInventoryDetails() {
		return inventoryDetails;
	}
	public void setInventoryDetails(Set<InventoryAdjustmentDetail> inventoryDetails) {
		this.inventoryDetails = inventoryDetails;
	}

}
