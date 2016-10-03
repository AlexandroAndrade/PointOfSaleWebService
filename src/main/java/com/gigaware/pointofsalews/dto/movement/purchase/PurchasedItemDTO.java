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
public class PurchasedItemDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -6020564943998388596L;
	
	private Long idItem;
	private Float quantity;
	private Float cost;
	
	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem( Long idItem ) {
		this.idItem = idItem;
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
	
}
