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
@Table( name = "MovimientoMercanciaDetalle" )
public class WareMovementDetail extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -7487073357432768542L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY	)
	@Column( name = "idMovimientoMercanciaDetalle", nullable = false )
	private Long idWareMovementDetail;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idMovimientoMercanciaTotal", nullable = false )
	private WareMovementTotal wareMovementTotal;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idArticulo", nullable = false )
	private SaleItem saleItem;
	
	@Column( name = "cantidad", nullable = false )
	private Float quantity;
	
	@Column( name = "costoPromedio", nullable = false )
	private Float averageCost;

	public Long getIdWareMovementDetail() {
		return idWareMovementDetail;
	}

	public void setIdWareMovementDetail( Long idWareMovementDetail ) {
		this.idWareMovementDetail = idWareMovementDetail;
	}

	public WareMovementTotal getWareMovementTotal() {
		return wareMovementTotal;
	}

	public void setWareMovementTotal( WareMovementTotal wareMovementTotal ) {
		this.wareMovementTotal = wareMovementTotal;
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

}
