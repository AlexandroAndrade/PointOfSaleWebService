/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class SaleDetail extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 7525726654060657233L;

	private Long idSaleDetail;
	private SaleTotal saleTotal;
	private SaleItem salesItem;
	private Float quantity;
	private Float averageCost;
	private Float salePrice;

	public Long getIdSaleDetail() {
		return idSaleDetail;
	}

	public void setIdSaleDetail( Long idSaleDetail ) {
		this.idSaleDetail = idSaleDetail;
	}

	public SaleTotal getSaleTotal() {
		return saleTotal;
	}

	public void setSaleTotal( SaleTotal saleTotal ) {
		this.saleTotal = saleTotal;
	}

	public SaleItem getSalesItem() {
		return salesItem;
	}

	public void setSalesItem( SaleItem salesItem ) {
		this.salesItem = salesItem;
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

}
