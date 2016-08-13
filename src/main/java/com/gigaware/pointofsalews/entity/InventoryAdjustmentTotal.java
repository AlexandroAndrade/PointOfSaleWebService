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
@Table( name = "ajusteinventariototal" )
public class InventoryAdjustmentTotal extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 728980412820740749L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "idAjusteInventarioTotal", nullable = false )
	private Long idInventoryAdjustmentTotal;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idUsuario", nullable = false )
	private User user;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idSucursal", nullable = false )
	private Branch branch;
	
	@Column( name = "fechaAjuste", nullable = false )
	private Date adjustmentDate;
	
	@Column( name = "totalExcedentes", nullable = false )
	private Float totalSurplus;
	
	@Column( name = "totalPerdidas", nullable = false )
	private Float totalLoss;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "inventoryAdjustmentTotal" )
	private Set<InventoryAdjustmentDetail> inventoryDetails = new HashSet<>();

	public Long getIdInventoryAdjustmentTotal() {
		return idInventoryAdjustmentTotal;
	}

	public void setIdInventoryAdjustmentTotal( Long idInventoryAdjustmentTotal ) {
		this.idInventoryAdjustmentTotal = idInventoryAdjustmentTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser( User user ) {
		this.user = user;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch( Branch branch ) {
		this.branch = branch;
	}

	public Date getAdjustmentDate() {
		return adjustmentDate;
	}

	public void setAdjustmentDate( Date adjustmentDate ) {
		this.adjustmentDate = adjustmentDate;
	}

	public Float getTotalSurplus() {
		return totalSurplus;
	}

	public void setTotalSurplus( Float totalSurplus ) {
		this.totalSurplus = totalSurplus;
	}

	public Float getTotalLoss() {
		return totalLoss;
	}

	public void setTotalLoss( Float totalLoss ) {
		this.totalLoss = totalLoss;
	}

	public Set<InventoryAdjustmentDetail> getInventoryDetails() {
		return inventoryDetails;
	}

	public void setInventoryDetails( Set<InventoryAdjustmentDetail> inventoryDetails ) {
		this.inventoryDetails = inventoryDetails;
	}

}
