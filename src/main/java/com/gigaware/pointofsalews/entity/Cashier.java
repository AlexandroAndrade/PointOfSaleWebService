/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "caja" )
public class Cashier extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -95612637489129962L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "idCaja", nullable = false )
	private Long idCashier;
	
	@Column( name = "nombreCaja", nullable = false )
	private String cashierName;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "cashier" )
	private Set<SaleTotal> sales = new HashSet<>();

	public Long getIdCashier() {
		return idCashier;
	}

	public void setIdCashier( Long idCashier ) {
		this.idCashier = idCashier;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName( String cashierName ) {
		this.cashierName = cashierName;
	}

	public Set<SaleTotal> getSales() {
		return sales;
	}

	public void setSales( Set<SaleTotal> sales ) {
		this.sales = sales;
	}

}
