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
@Table( name = "AjusteInventarioDetalle", uniqueConstraints = 
	@UniqueConstraint( columnNames = { "idAjusteInventarioTotal", "idArticulo"})
)
public class InventoryAdjustmentDetail extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -8120907710552984292L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "", nullable = false )
	private Long idInventoryAdjustmentDetail;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idAjusteInventarioTotal", nullable = false )
	private InventoryAdjustmentTotal inventoryAdjustmentTotal;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idArticulo", nullable = false )
	private SaleItem saleItem;
	
	@Column( name = "existenciaAnterior", nullable = false )
	private Float previousStock;
	
	@Column( name = "existenciaNueva", nullable = false )
	private Float adjsutedStock;
	
	@Column( name = "costoAjuste", nullable = false )
	private Float adjustmentCost;

	public Long getIdInventoryAdjustmentDetail() {
		return idInventoryAdjustmentDetail;
	}

	public void setIdInventoryAdjustmentDetail( Long idInventoryAdjustmentDetail ) {
		this.idInventoryAdjustmentDetail = idInventoryAdjustmentDetail;
	}

	public InventoryAdjustmentTotal getInventoryAdjustmentTotal() {
		return inventoryAdjustmentTotal;
	}

	public void setInventoryAdjustmentTotal( InventoryAdjustmentTotal inventoryAdjustmentTotal ) {
		this.inventoryAdjustmentTotal = inventoryAdjustmentTotal;
	}

	public SaleItem getSaleItem() {
		return saleItem;
	}

	public void setSaleItem( SaleItem saleItem ) {
		this.saleItem = saleItem;
	}

	public Float getPreviousStock() {
		return previousStock;
	}

	public void setPreviousStock( Float previousStock ) {
		this.previousStock = previousStock;
	}

	public Float getAdjsutedStock() {
		return adjsutedStock;
	}

	public void setAdjsutedStock( Float adjsutedStock ) {
		this.adjsutedStock = adjsutedStock;
	}

	public Float getAdjustmentCost() {
		return adjustmentCost;
	}

	public void setAdjustmentCost( Float adjustmentCost ) {
		this.adjustmentCost = adjustmentCost;
	}

}
