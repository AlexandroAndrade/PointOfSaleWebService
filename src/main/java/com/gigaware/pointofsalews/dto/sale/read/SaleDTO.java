/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.sale.read;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "sale" )
@XmlAccessorType( XmlAccessType.FIELD )
public class SaleDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 5681910809273021259L;

	private String ticketNumber;
	private String saleDate;
	private String cashierName;
	private String userName;
	
	private Float netTotal;
	private Float totalTaxes;
	private Float paymentAmount;
	
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
	
	public Float getNetTotal() {
		return netTotal;
	}
	
	public void setNetTotal( Float netTotal ) {
		this.netTotal = netTotal;
	}
	
	public Float getTotalTaxes() {
		return totalTaxes;
	}
	
	public void setTotalTaxes( Float totalTaxes ) {
		this.totalTaxes = totalTaxes;
	}
	
	public Float getPaymentAmount() {
		return paymentAmount;
	}
	
	public void setPaymentAmount( Float paymentAmount ) {
		this.paymentAmount = paymentAmount;
	}

}
