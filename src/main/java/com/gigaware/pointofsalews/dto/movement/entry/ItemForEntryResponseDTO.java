/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.movement.entry;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "entryItem" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ItemForEntryResponseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -5420338642029416637L;
	
	private String itemKey;
	private String itemName;
	private Float entryQuantity;
	
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
	
	public Float getEntryQuantity() {
		return entryQuantity;
	}
	
	public void setEntryQuantity( Float entryQuantity ) {
		this.entryQuantity = entryQuantity;
	}

}
