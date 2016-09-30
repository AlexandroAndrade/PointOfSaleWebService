/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.sale.create;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private Float totalPrice;
	private Float totalTaxes;
	private Float change;
	
	@XmlElement( name = "items" )
	private List<ItemForSaleDTO> items = new ArrayList<>();

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

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice( Float totalPrice ) {
		this.totalPrice = totalPrice;
	}

	public Float getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes( Float totalTaxes ) {
		this.totalTaxes = totalTaxes;
	}

	public Float getChange() {
		return change;
	}

	public void setChange( Float change ) {
		this.change = change;
	}

	public List<ItemForSaleDTO> getItems() {
		return items;
	}

	public void setItems( List<ItemForSaleDTO> items ) {
		this.items = items;
	}

}
