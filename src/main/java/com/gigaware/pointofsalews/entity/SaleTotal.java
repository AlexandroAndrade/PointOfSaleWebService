/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class SaleTotal 	extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -8569734029213958432L;	
	
	private Long idSaleTotal;
	private Branch branch;
	private Cashier cashier;
	private User user;
	private Date saleDate;
	private Float totalSale;
	private Float moneyChange;
	private String ticketNumber;
	private Set<SaleDetail> saleDetails = new HashSet<>();
	
	public Long getIdSaleTotal() {
		return idSaleTotal;
	}
	public void setIdSaleTotal(Long idSaleTotal) {
		this.idSaleTotal = idSaleTotal;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Cashier getCashier() {
		return cashier;
	}
	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public Float getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(Float totalSale) {
		this.totalSale = totalSale;
	}
	public Float getMoneyChange() {
		return moneyChange;
	}
	public void setMoneyChange(Float moneyChange) {
		this.moneyChange = moneyChange;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public Set<SaleDetail> getSaleDetails() {
		return saleDetails;
	}
	public void setSaleDetails(Set<SaleDetail> saleDetails) {
		this.saleDetails = saleDetails;
	}

}
