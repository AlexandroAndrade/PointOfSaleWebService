/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class Cashier extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -95612637489129962L;
	
	private Long idCashier;
	private String cashierName;
	private Set<SaleTotal> sales = new HashSet<>();
	
	public Long getIdCashier() {
		return idCashier;
	}
	public void setIdCashier(Long idCashier) {
		this.idCashier = idCashier;
	}
	public String getCashierName() {
		return cashierName;
	}
	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}
	public Set<SaleTotal> getSales() {
		return sales;
	}
	public void setSales(Set<SaleTotal> sales) {
		this.sales = sales;
	}

}
