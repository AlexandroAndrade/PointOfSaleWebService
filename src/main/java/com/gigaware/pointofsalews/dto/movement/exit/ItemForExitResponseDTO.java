/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.movement.exit;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "exitItem" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ItemForExitResponseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -9143149674318591261L;
	
	private String itemKey;
	private String itemName;
	private Float exitQuantity;
	
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
	
	public Float getExitQuantity() {
		return exitQuantity;
	}
	
	public void setExitQuantity( Float exitQuantity ) {
		this.exitQuantity = exitQuantity;
	}

}
