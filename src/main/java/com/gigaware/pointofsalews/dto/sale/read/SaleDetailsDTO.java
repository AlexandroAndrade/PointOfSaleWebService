/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.sale.read;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class SaleDetailsDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -6206603234199626564L;

	private String branchName;
	private String ticketNumber;
	private String saleDate;
	private String cashierName;
	private String userName;
	private Float netTotal;
	private Float totalTaxes;
	private Float paymentAmount;
	
	private List<SoldItemDetailsDTO> soldItems = new ArrayList<>();

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

	public List<SoldItemDetailsDTO> getSoldItems() {
		return soldItems;
	}

	public void setSoldItems( List<SoldItemDetailsDTO> soldItems ) {
		this.soldItems = soldItems;
	}
	
}
