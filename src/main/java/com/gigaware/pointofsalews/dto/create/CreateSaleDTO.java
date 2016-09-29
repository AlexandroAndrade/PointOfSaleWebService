/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.create;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "sale" )
@XmlAccessorType( XmlAccessType.FIELD )
public class CreateSaleDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 7069148730686234891L;
	
	private Long idBranch;
	private Long idCashier;
	private Long idUser;
	private String saleDate;
	private float totalPrice;
	private float change;
	
	@XmlElement( name = "items" )
	private Set<ItemForSaleDTO> items = new HashSet<>();

	public Long getIdBranch() {
		return idBranch;
	}

	public void setIdBranch( Long idBranch ) {
		this.idBranch = idBranch;
	}

	public Long getIdCashier() {
		return idCashier;
	}

	public void setIdCashier( Long idCashier ) {
		this.idCashier = idCashier;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser( Long idUser ) {
		this.idUser = idUser;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate( String saleDate ) {
		this.saleDate = saleDate;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice( float totalPrice ) {
		this.totalPrice = totalPrice;
	}

	public float getChange() {
		return change;
	}

	public void setChange( float change ) {
		this.change = change;
	}

	public Set<ItemForSaleDTO> getItems() {
		return items;
	}

	public void setItems( Set<ItemForSaleDTO> items ) {
		this.items = items;
	}
	
	
	
	
}
