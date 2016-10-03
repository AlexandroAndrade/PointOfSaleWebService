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
public class WastedItemDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 6381481129198966007L;

	private Long idItem;
	private Float wastedQuantity;
	
	public Long getIdItem() {
		return idItem;
	}
	
	public void setIdItem( Long idItem ) {
		this.idItem = idItem;
	}
	
	public Float getWastedQuantity() {
		return wastedQuantity;
	}
	
	public void setWastedQuantity( Float wastedQuantity ) {
		this.wastedQuantity = wastedQuantity;
	}
	
}
