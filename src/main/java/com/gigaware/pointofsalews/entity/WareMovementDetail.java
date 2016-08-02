/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class WareMovementDetail extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -7487073357432768542L;
	
	private Long idWareMovementDetail;
	private WareMovementTotal wareMovementTotal;
	private SalesItem salesItem;
	private Float quantity;
	private Float averageCost;
	
	public Long getIdWareMovementDetail() {
		return idWareMovementDetail;
	}
	public void setIdWareMovementDetail(Long idWareMovementDetail) {
		this.idWareMovementDetail = idWareMovementDetail;
	}
	public WareMovementTotal getWareMovementTotal() {
		return wareMovementTotal;
	}
	public void setWareMovementTotal(WareMovementTotal wareMovementTotal) {
		this.wareMovementTotal = wareMovementTotal;
	}
	public SalesItem getSalesItem() {
		return salesItem;
	}
	public void setSalesItem(SalesItem salesItem) {
		this.salesItem = salesItem;
	}
	public Float getQuantity() {
		return quantity;
	}
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	public Float getAverageCost() {
		return averageCost;
	}
	public void setAverageCost(Float averageCost) {
		this.averageCost = averageCost;
	}

}
