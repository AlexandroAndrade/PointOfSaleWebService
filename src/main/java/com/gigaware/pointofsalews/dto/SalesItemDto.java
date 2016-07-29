/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import com.gigaware.pointofsalews.entity.SalesItem;
import com.sun.xml.txw2.annotation.XmlElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlElement( value = "salesItem" )
@XmlAccessorType( XmlAccessType.FIELD )
public class SalesItemDto implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -3750189378668874083L;

	private Long idSalesItem;
	private String itemKey;
	private String itemName;
	private Float averageCost;
	private Float salePrice;
	private List<InventoryBranch> inventory = new ArrayList<>();
	private String codeBar;
	private String providerName;
	private String department;

	/**
	 * Empty Constructor
	 */
	public SalesItemDto() {
	}

	/**
	 * Custom constructor
	 */
	public SalesItemDto(SalesItem item) {
		this.idSalesItem = item.getIdItem();
		this.itemName = StringUtils.defaultString( item.getItemName(), EMPTY );
		this.averageCost = item.getAverageCost();
		this.salePrice = item.getSalePrice();

		//TODO - Mapping the respective Inventory - Branch
		
		this.codeBar = StringUtils.defaultString( item.getCodeBar(), EMPTY );
		this.providerName = StringUtils.defaultString( item.getProvider().getBusinessName(), EMPTY );
	}

	public Long getIdSalesItem() {
		return idSalesItem;
	}

	public void setIdSalesItem( Long idSalesItem ) {
		this.idSalesItem = idSalesItem;
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

	public void setItemName( String itemName ) {
		this.itemName = itemName;
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

	public List<InventoryBranch> getInventory() {
		return inventory;
	}

	public void setInventory(List<InventoryBranch> inventory) {
		this.inventory = inventory;
	}


	public void setSalePrice( Float salePrice ) {
		this.salePrice = salePrice;
	}

//	public Float getInventory() {
//		return inventory;
//	}
//
//	public void setInventory( Float inventory ) {
//		this.inventory = inventory;
//	}

	public String getCodeBar() {
		return codeBar;
	}

	public void setCodeBar( String codeBar ) {
		this.codeBar = codeBar;
	}

//	public String getBranchName() {
//		return branchName;
//	}
//
//	public void setBranchName( String branchName ) {
//		this.branchName = branchName;
//	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName( String providerName ) {
		this.providerName = providerName;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory( String category ) {
//		this.category = category;
//	}
	
	

}