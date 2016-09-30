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
@XmlRootElement( name= "sale" )
@XmlAccessorType( XmlAccessType.FIELD )
public class RegisteredSaleDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -2907227644097783217L;
	
	private String branchName;
	private String ticketNumber;
	private String saleDate;
	
	@XmlElement( name = "items" )
	private List<ItemForTicketDTO> soldItems = new ArrayList<>();
	
	private Float totalNetPrice;
	private Float totalTaxes;
	
	private Float income;
	private Float change;
	
	private String cashierName;
	private String userName;
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName( String branchName ) {
		this.branchName = branchName;
	}
	
	public String getTicketNumber() {
		return ticketNumber;
	}
	
	public void setTicketNumber( String ticketNumber ) {
		this.ticketNumber = ticketNumber;
	}
	
	public String getSaleDate() {
		return saleDate;
	}
	
	public void setSaleDate( String saleDate ) {
		this.saleDate = saleDate;
	}
	
	public List<ItemForTicketDTO> getSoldItems() {
		return soldItems;
	}
	
	public void setSoldItems( List<ItemForTicketDTO> soldItems ) {
		this.soldItems = soldItems;
	}
	
	public Float getTotalNetPrice() {
		return totalNetPrice;
	}
	
	public void setTotalNetPrice( Float totalNetPrice ) {
		this.totalNetPrice = totalNetPrice;
	}
	
	public Float getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes( Float totalTaxes ) {
		this.totalTaxes = totalTaxes;
	}

	public Float getIncome() {
		return income;
	}
	
	public void setIncome( Float income ) {
		this.income = income;
	}
	
	public Float getChange() {
		return change;
	}
	
	public void setChange( Float change ) {
		this.change = change;
	}
	
	public String getCashierName() {
		return cashierName;
	}
	
	public void setCashierName( String cashierName ) {
		this.cashierName = cashierName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName( String userName ) {
		this.userName = userName;
	}

}
