/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.movement.purchase;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "purchasedItem" )
@XmlAccessorType( XmlAccessType.FIELD )
public class PurchasedItemResponseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 2679170615023405734L;

	private String itemKey;
	private String itemName;
	private Float quantity;
	private Float cost;
	private Float newAverageCost;
	
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
	
	public Float getQuantity() {
		return quantity;
	}
	
	public void setQuantity( Float quantity ) {
		this.quantity = quantity;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost( Float cost ) {
		this.cost = cost;
	}

	public Float getNewAverageCost() {
		return newAverageCost;
	}

	public void setNewAverageCost( Float newAverageCost ) {
		this.newAverageCost = newAverageCost;
	}

}
