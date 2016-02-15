/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.create;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.sun.xml.txw2.annotation.XmlElement;


/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlElement( value = "salesItemCreate" )
@XmlAccessorType( XmlAccessType.FIELD )
@JsonIgnoreProperties( ignoreUnknown = true )
public class SalesItemCreate implements Serializable {

	/**
	 * AspctJ
	 */
	private static final long serialVersionUID = 6955326315863736109L;
	
	private String itemName;
	private Float averageCost;
	private Float salePrice;
	private Float inventory;
	private String codeBar;
	private Long idBranch;
	private Long idProvider;
	
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
	public Long getIdBranch() {
		return idBranch;
	}
	public void setIdBranch(Long idBranch) {
		this.idBranch = idBranch;
	}
	public Long getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(Long idProvider) {
		this.idProvider = idProvider;
	}
	
	
	

}
