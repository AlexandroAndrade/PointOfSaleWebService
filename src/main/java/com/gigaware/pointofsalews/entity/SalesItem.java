/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
//@Entity
//@Table( name = "articulo", uniqueConstraints = {
//        @UniqueConstraint( columnNames = "nombreArticulo"),
//        @UniqueConstraint( columnNames = "codigoBarras")
//		}
//)
public class SalesItem implements Serializable {
    
    /**
	 * AspectJ
	 */
	private static final long serialVersionUID = -9197884745195157740L;

//	@Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY )
//    @Column( name = "idArticulo" , nullable = false )
    private Long idItem;
    
	//TODO - Mapping against DB Table
	private String itemKey;
	
//    @Column( name = "nombreArticulo", length = 100, nullable = false )
    private String itemName;
    
//  @ManyToOne( fetch = FetchType.LAZY )
//  @JoinColumn( name = "idProveedor", nullable = false )
    private Provider provider;

//  @ManyToOne( fetch = FetchType.LAZY )
//  @JoinColumn( name = "idDepartamento", nullable = false )
    private Department department;

//  @ManyToOne( fetch = FetchType.LAZY )
//  @JoinColumn( name = "Marca", nullable = false )
    private String branch;

//  @Column( name = "codigoBarras", length = 45, nullable = true )
    private String codeBar;

//  @Column( name = "costoPromedio", nullable = false )
  	private Float averageCost;

//  @Column( name = "precioVenta", nullable = false )
    private Float salePrice;

    private Set<Inventory> inventory = new HashSet<>();
    
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

}