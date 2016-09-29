/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gigaware.pointofsalews.dto.create.SalesItemCreateDTO;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "articulo" )
public class SaleItem extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -9197884745195157740L;
	
	/**
	 * Default Empty Constructor
	 */
	public SaleItem() { }
	
	public SaleItem( SalesItemCreateDTO saleItemDto ) {
		this.itemKey = saleItemDto.getItemKey();
		this.itemName = saleItemDto.getItemName();
		this.averageCost = 0.0F ;
		this.brand = saleItemDto.getBrand();
		this.codeBars = saleItemDto.getCodeBars();
		this.salePrice = saleItemDto.getSalePrice();
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "idArticulo", nullable = false )
	private Long idItem;
	
	@Column( name = "claveArticulo", nullable = false )
	private String itemKey;
	
	@Column( name = "nombreArticulo", nullable = false )
	private String itemName;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idProveedor", nullable = false )
	private Provider provider;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idDepartamento", nullable = false )
	private Department department;
	
	@Column( name = "marca", nullable = false )
	private String brand;
	
	@Column( name = "codigoBarras", nullable = true )
	private String codeBars;
	
	@Column( name = "costoPromedio", nullable = false )
	private Float averageCost;
	
	@Column( name = "precioVenta", nullable = false )
	private Float salePrice;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "saleItem", cascade = CascadeType.ALL )
	private Set<Inventory> inventory = new HashSet<>();
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "saleItem" )
	private Set<WareMovementDetail> saleItemMovements = new HashSet<>();
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "saleItem" )
	private Set<SaleDetail> salesDetails = new HashSet<>();
	
	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem( Long idItem ) {
		this.idItem = idItem;
	}

	public String getItemKey() {
		return itemKey;
	}

	public void setItemKey( String itemKey ) {
		this.itemKey = itemKey;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName( String itemName ) {
		this.itemName = itemName;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider( Provider provider ) {
		this.provider = provider;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment( Department department ) {
		this.department = department;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand( String brand ) {
		this.brand = brand;
	}

	public String getCodeBars() {
		return codeBars;
	}

	public void setCodeBars( String codeBars ) {
		this.codeBars = codeBars;
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

	public Set<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory( Set<Inventory> inventory ) {
		this.inventory = inventory;
	}

	public Set<WareMovementDetail> getSaleItemMovements() {
		return saleItemMovements;
	}

	public void setSaleItemMovements( Set<WareMovementDetail> saleItemMovements ) {
		this.saleItemMovements = saleItemMovements;
	}

	public Set<SaleDetail> getSalesDetails() {
		return salesDetails;
	}

	public void setSalesDetails( Set<SaleDetail> salesDetails ) {
		this.salesDetails = salesDetails;
	}
	
	

}