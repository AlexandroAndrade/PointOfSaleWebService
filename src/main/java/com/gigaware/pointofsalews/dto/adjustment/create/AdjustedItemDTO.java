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
public class AdjustedItemDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 187291473003061396L;
	
	private Long idItem;
	private Float stockFound;
	
	public Long getIdItem() {
		return idItem;
	}
	
	public void setIdItem( Long idItem ) {
		this.idItem = idItem;
	}
	
	public Float getStockFound() {
		return stockFound;
	}
	
	public void setStockFound( Float stockFound ) {
		this.stockFound = stockFound;
	}

}
