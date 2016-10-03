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
@XmlRootElement( name = "purchase")
@XmlAccessorType( XmlAccessType.FIELD )
public class WarePurchaseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 7871063290909991501L;

	private Long idBranch;
	private Long idUser;
	private String movementDate;
	private Float totalMovementCost;
	private String remissionNumber;
	
	@XmlElement( name = "purchasedItems" )
	private List<PurchasedItemDTO> purchasedItems = new ArrayList<>();

	public Long getIdBranch() {
		return idBranch;
	}

	public void setIdBranch( Long idBranch ) {
		this.idBranch = idBranch;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser( Long idUser ) {
		this.idUser = idUser;
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

	public List<PurchasedItemDTO> getPurchasedItems() {
		return purchasedItems;
	}

	public void setPurchasedItems( List<PurchasedItemDTO> purchasedItems ) {
		this.purchasedItems = purchasedItems;
	}
	
	
	
}
