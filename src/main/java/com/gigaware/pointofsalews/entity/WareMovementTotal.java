/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gigaware.pointofsalews.entity.MovementType;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class WareMovementTotal extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 6952628664286067299L;

	private Long idWareMovementTotal;
	private Branch branch;
	private MovementType movementType;
	private User user;
	private Date movementDate;
	private Float totalMovementCost;
	private String remissionNumber;
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
