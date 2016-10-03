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
public class DamagedItemDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -6927411688947936972L;

	private Long idItem;
	private Float damagedQuantity;
	
	public Long getIdItem() {
		return idItem;
	}
	
	public void setIdItem( Long idItem ) {
		this.idItem = idItem;
	}
	
	public Float getDamagedQuantity() {
		return damagedQuantity;
	}
	
	public void setDamagedQuantity( Float damagedQuantity ) {
		this.damagedQuantity = damagedQuantity;
	}
	
}
