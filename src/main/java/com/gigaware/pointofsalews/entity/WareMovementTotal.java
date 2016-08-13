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

import com.gigaware.pointofsalews.entity.MovementType;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "movimientomercanciatotal" )
public class WareMovementTotal extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 6952628664286067299L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY	)
	@Column( name = "idMovimientoMercanciaTotal", nullable = false )
	private Long idWareMovementTotal;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idSucursal", nullable = false )
	private Branch branch;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "claveTipoMovimiento", nullable = false )
	private MovementType movementType;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idUsuario", nullable = false )
	private User user;
	
	@Column( name = "fechaMovimientoMercancia", nullable = false )
	private Date movementDate;
	
	@Column( name = "totalCostoMovimiento", nullable = false )
	private Float totalMovementCost;
	
	@Column( name = "numeroRemision", nullable = false )
	private String remissionNumber;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "wareMovementTotal" )
	private Set<WareMovementDetail> movementDetails = new HashSet<>();

	public Long getIdWareMovementTotal() {
		return idWareMovementTotal;
	}

	public void setIdWareMovementTotal( Long idWareMovementTotal ) {
		this.idWareMovementTotal = idWareMovementTotal;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch( Branch branch ) {
		this.branch = branch;
	}

	public MovementType getMovementType() {
		return movementType;
	}

	public void setMovementType( MovementType movementType ) {
		this.movementType = movementType;
	}

	public User getUser() {
		return user;
	}

	public void setUser( User user ) {
		this.user = user;
	}

	public Date getMovementDate() {
		return movementDate;
	}

	public void setMovementDate( Date movementDate ) {
		this.movementDate = movementDate;
	}

	public Float getTotalMovementCost() {
		return totalMovementCost;
	}

	public void setTotalMovementCost( Float totalMovementCost ) {
		this.totalMovementCost = totalMovementCost;
	}

	public String getRemissionNumber() {
		return remissionNumber;
	}

	public void setRemissionNumber( String remissionNumber ) {
		this.remissionNumber = remissionNumber;
	}

	public Set<WareMovementDetail> getMovementDetails() {
		return movementDetails;
	}

	public void setMovementDetails( Set<WareMovementDetail> movementDetails ) {
		this.movementDetails = movementDetails;
	}

}
