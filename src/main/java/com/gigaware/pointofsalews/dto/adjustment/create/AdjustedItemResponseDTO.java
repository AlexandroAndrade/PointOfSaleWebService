/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.adjustment.create;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "adjustedItem" )
@XmlAccessorType( XmlAccessType.FIELD )
public class AdjustedItemResponseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -1169144059615822615L;
	
	private String itemKey;
	private String itemName;
	private Float stockFound;
	
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
	
	public Float getStockFound() {
		return stockFound;
	}
	
	public void setStockFound( Float stockFound ) {
		this.stockFound = stockFound;
	}

}
