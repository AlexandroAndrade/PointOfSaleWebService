/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.sale.create;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "soldItem" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ItemForTicketDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 7850024699055877393L;
	
	private Float quantity;
	private String itemName;
	private Float netPrice;
	private Float tax;
	
	public Float getQuantity() {
		return quantity;
	}
	
	public void setQuantity( Float quantity ) {
		this.quantity = quantity;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName( String itemName ) {
		this.itemName = itemName;
	}
	
	public Float getNetPrice() {
		return netPrice;
	}
	
	public void setNetPrice( Float netPrice ) {
		this.netPrice = netPrice;
	}
	
	public Float getTax() {
		return tax;
	}
	
	public void setTax( Float tax ) {
		this.tax = tax;
	}

}
