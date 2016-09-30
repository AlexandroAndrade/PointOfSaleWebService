/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "ventadetalle" )
public class SaleDetail extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 7525726654060657233L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "idVentaDetalle", nullable = false )
	private Long idSaleDetail;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idVentaTotal", nullable = false )
	private SaleTotal saleTotal;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idArticulo", nullable = false )
	private SaleItem saleItem;
	
	@Column( name = "cantidad", nullable = false )
	private Float quantity;
	
	@Column( name = "costoPromedio", nullable = false )
	private Float averageCost;
	
	@Column( name = "precioNeto", nullable = false )
	private Float netPrice;
	
	@Column( name = "iva", nullable = false )
	private Float tax;

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

	public SaleItem getSaleItem() {
		return saleItem;
	}

	public void setSaleItem( SaleItem saleItem ) {
		this.saleItem = saleItem;
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

	public Float getNetPrice() {
		return netPrice;
	}

	public void setNetPrice( Float netPrice ) {
		this.netPrice = netPrice;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax( Float tax ) {
		this.tax = tax;
	}

}
