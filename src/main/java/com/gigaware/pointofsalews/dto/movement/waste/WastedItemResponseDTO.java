/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.movement.waste;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "wastedItem" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WastedItemResponseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -6532310517298423026L;

	private String itemKey;
	private String itemName;
	private Float wastedQuantity;
	
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
	
	public Float getWastedQuantity() {
		return wastedQuantity;
	}
	
	public void setWastedQuantity( Float wastedQuantity ) {
		this.wastedQuantity = wastedQuantity;
	}
	
}

