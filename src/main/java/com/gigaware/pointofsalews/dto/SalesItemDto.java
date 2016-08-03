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

import com.gigaware.pointofsalews.entity.Inventory;
import com.gigaware.pointofsalews.entity.SaleItem;
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
	private List<InventoryBranchDto> inventory = new ArrayList<>();
	private String codeBars;
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
	public SalesItemDto(SaleItem item) {
		this.idSalesItem = item.getIdItem();
		this.itemKey = item.getItemKey();
		this.itemName = StringUtils.defaultString( item.getItemName(), EMPTY );
		this.averageCost = item.getAverageCost();
		this.salePrice = item.getSalePrice();
		
		for( Inventory inv : item.getInventory() ) {
			InventoryBranchDto invDto = new InventoryBranchDto();
			invDto.setBranchName( inv.getBranch().getBranchName() );
			invDto.setInventory( inv.getInventory() );
			this.inventory.add( invDto );
		}
		
		this.codeBars = StringUtils.defaultString( item.getCodeBars(), EMPTY );
		this.providerName = StringUtils.defaultString( item.getProvider().getBusinessName(), EMPTY );
		this.department = StringUtils.defaultString( item.getDepartment().getDepartmentName(), EMPTY );
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

	public List<InventoryBranchDto> getInventory() {
		return inventory;
	}

	public void setInventory( List<InventoryBranchDto> inventory ) {
		this.inventory = inventory;
	}

	public void setSalePrice( Float salePrice ) {
		this.salePrice = salePrice;
	}

	public String getCodeBars() {
		return codeBars;
	}

	public void setCodeBars( String codeBars ) {
		this.codeBars = codeBars;
	}

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

}