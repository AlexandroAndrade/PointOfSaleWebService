/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.create;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name =  "item" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ItemForSaleDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 4680916026771573466L;
	
	private Long idItem;
	private Float quantity;
	private Float averageCost;
	private Float salePrice;
	
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
	
	public Float getAverageCost() {
		return averageCost;
	}
	
	public void setAverageCost( Float averageCost ) {
		this.averageCost = averageCost;
	}
	
	public Float getSalePrice() {
		return salePrice;
	}
	
	public void setSalePrice( Float salePrice ) {
		this.salePrice = salePrice;
	}
	
	@Override
	public boolean equals( Object o ) {
		
		if ( o instanceof ItemForSaleDTO ){
			
			ItemForSaleDTO i = ( ItemForSaleDTO ) o;
			return this.idItem.longValue() == i.getIdItem().longValue();
		
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append( this.idItem ).hashCode();
	}


}
