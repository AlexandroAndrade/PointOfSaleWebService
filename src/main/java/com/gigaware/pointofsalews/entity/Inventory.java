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
 * N to M relationship class
 * 
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "inventario" )
public class Inventory extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 7305928501070070318L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "idInventario", nullable = false )
	private Long idInventory;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idArticulo", nullable = false )
	private SaleItem saleItem;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idSucursal", nullable = false )
	private Branch branch;
	
	@Column( name = "existencias", nullable = false )
	private Float inventory;

	public Long getIdInventory() {
		return idInventory;
	}

	public void setIdInventory( Long idInventory ) {
		this.idInventory = idInventory;
	}

	public SaleItem getSaleItem() {
		return saleItem;
	}

	public void setSaleItem( SaleItem saleItem ) {
		this.saleItem = saleItem;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch( Branch branch ) {
		this.branch = branch;
	}

	public Float getInventory() {
		return inventory;
	}

	public void setInventory( Float inventory ) {
		this.inventory = inventory;
	}

}
