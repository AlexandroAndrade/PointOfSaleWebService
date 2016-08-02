/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class InventoryAdjustmentDetail extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -8120907710552984292L;
	
	private Long idInventoryAdjustmentDetail;
	private InventoryAdjustmentTotal inventoryAdjustmentTotal;
	private SaleItem saleItem;
	private Float previousStock;
	private Float adjsutedStock;
	private Float adjustmentCost;
	
	public Long getIdInventoryAdjustmentDetail() {
		return idInventoryAdjustmentDetail;
	}
	public void setIdInventoryAdjustmentDetail(Long idInventoryAdjustmentDetail) {
		this.idInventoryAdjustmentDetail = idInventoryAdjustmentDetail;
	}
	public InventoryAdjustmentTotal getInventoryAdjustmentTotal() {
		return inventoryAdjustmentTotal;
	}
	public void setInventoryAdjustmentTotal(
			InventoryAdjustmentTotal inventoryAdjustmentTotal) {
		this.inventoryAdjustmentTotal = inventoryAdjustmentTotal;
	}
	public SaleItem getSaleItem() {
		return saleItem;
	}
	public void setSaleItem(SaleItem saleItem) {
		this.saleItem = saleItem;
	}
	public Float getPreviousStock() {
		return previousStock;
	}
	public void setPreviousStock(Float previousStock) {
		this.previousStock = previousStock;
	}
	public Float getAdjsutedStock() {
		return adjsutedStock;
	}
	public void setAdjsutedStock(Float adjsutedStock) {
		this.adjsutedStock = adjsutedStock;
	}
	public Float getAdjustmentCost() {
		return adjustmentCost;
	}
	public void setAdjustmentCost(Float adjustmentCost) {
		this.adjustmentCost = adjustmentCost;
	}

}
