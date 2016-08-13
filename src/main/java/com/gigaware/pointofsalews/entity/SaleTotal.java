/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "ventatotal" )
public class SaleTotal extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -8569734029213958432L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "idVentaTotal", nullable = false )
	private Long idSaleTotal;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idSucursal", nullable = false )
	private Branch branch;

	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idCaja", nullable = false )
	private Cashier cashier;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idUsuario", nullable = false )
	private User user;
	
	@Column( name = "fechaVenta", nullable = false )
	private Date saleDate;

	@Column( name = "totalVenta", nullable = false )
	private Float totalSale;

	@Column( name = "cambio", nullable = false )
	private Float moneyChange;

	@Column( name = "numeroTicket", nullable = false )
	private String ticketNumber;

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "saleTotal" )
	private Set<SaleDetail> saleDetails = new HashSet<>();

	public Long getIdSaleTotal() {
		return idSaleTotal;
	}

	public void setIdSaleTotal( Long idSaleTotal ) {
		this.idSaleTotal = idSaleTotal;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch( Branch branch ) {
		this.branch = branch;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier( Cashier cashier ) {
		this.cashier = cashier;
	}

	public User getUser() {
		return user;
	}

	public void setUser( User user ) {
		this.user = user;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate( Date saleDate ) {
		this.saleDate = saleDate;
	}

	public Float getTotalSale() {
		return totalSale;
	}

	public void setTotalSale( Float totalSale ) {
		this.totalSale = totalSale;
	}

	public Float getMoneyChange() {
		return moneyChange;
	}

	public void setMoneyChange( Float moneyChange ) {
		this.moneyChange = moneyChange;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber( String ticketNumber ) {
		this.ticketNumber = ticketNumber;
	}

	public Set<SaleDetail> getSaleDetails() {
		return saleDetails;
	}

	public void setSaleDetails( Set<SaleDetail> saleDetails ) {
		this.saleDetails = saleDetails;
	}

}
