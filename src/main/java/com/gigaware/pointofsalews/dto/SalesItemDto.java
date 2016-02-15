/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sun.xml.txw2.annotation.XmlElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlElement( value =  "salesItem")
@XmlAccessorType( XmlAccessType.FIELD )
public class SalesItemDto implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -3750189378668874083L;
	
	private Long idSalesItem;
	private String itemName;
	private Float averageCost;
	private Float salePrice;
	private Float inventory;
	private String codeBar;
	private String branchName;
	private String providerName;
	
	public Long getIdSalesItem() {
		return idSalesItem;
	}
	public void setIdSalesItem(Long idSalesItem) {
		this.idSalesItem = idSalesItem;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public Float getInventory() {
		return inventory;
	}
	public void setInventory(Float inventory) {
		this.inventory = inventory;
	}
	public String getCodeBar() {
		return codeBar;
	}
	public void setCodeBar(String codeBar) {
		this.codeBar = codeBar;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	

}
