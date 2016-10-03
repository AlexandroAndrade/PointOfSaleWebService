/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.movement.damage;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "damagedItem" )
@XmlAccessorType( XmlAccessType.FIELD )
public class DamagedItemResponseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 2276547943227247699L;
	
	private String itemKey;
	private String itemName;
	private Float damagedQuantity;
	
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
	
	public Float getDamagedQuantity() {
		return damagedQuantity;
	}
	
	public void setDamagedQuantity( Float damagedQuantity ) {
		this.damagedQuantity = damagedQuantity;
	}
	
}
