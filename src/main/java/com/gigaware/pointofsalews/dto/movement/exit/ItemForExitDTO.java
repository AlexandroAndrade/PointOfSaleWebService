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
@XmlRootElement( name = "item" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ItemForExitDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 9011127030756521224L;

	private Long idItem;
	private Float exitQuantity;
	
	public Long getIdItem() {
		return idItem;
	}
	
	public void setIdItem( Long idItem ) {
		this.idItem = idItem;
	}
	
	public Float getExitQuantity() {
		return exitQuantity;
	}
	
	public void setExitQuantity( Float exitQuantity ) {
		this.exitQuantity = exitQuantity;
	}
	
}
