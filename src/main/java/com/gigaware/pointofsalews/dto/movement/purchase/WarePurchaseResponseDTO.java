/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.movement.purchase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "warePurchase" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WarePurchaseResponseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 9197826540145180730L;

	private String branchName;
	private String userName;
	private String movementType;
	private String movementDate;
	private Float totalMovementCost;
	private String remissionNumber;
	
	@XmlElement( name = "purchasedItems" )
	private List<PurchasedItemResponseDTO> purchasedItems = new ArrayList<>();

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName( String branchName ) {
		this.branchName = branchName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName( String userName ) {
		this.userName = userName;
	}
	
	public String getMovementType() {
		return movementType;
	}

	public void setMovementType( String movementType ) {
		this.movementType = movementType;
	}

	public String getMovementDate() {
		return movementDate;
	}

	public void setMovementDate( String movementDate ) {
		this.movementDate = movementDate;
	}

	public Float getTotalMovementCost() {
		return totalMovementCost;
	}

	public void setTotalMovementCost( Float totalMovementCost ) {
		this.totalMovementCost = totalMovementCost;
	}

	public String getRemissionNumber() {
		return remissionNumber;
	}

	public void setRemissionNumber( String remissionNumber ) {
		this.remissionNumber = remissionNumber;
	}

	public List<PurchasedItemResponseDTO> getPurchasedItems() {
		return purchasedItems;
	}

	public void setPurchasedItems( List<PurchasedItemResponseDTO> purchasedItems ) {
		this.purchasedItems = purchasedItems;
	}
	
}
