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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "TipoMovimiento", uniqueConstraints = 
	@UniqueConstraint( columnNames = "tipoMovimiento" )
)
public class MovementType extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 190509682899340909L;

	@Id
	@Column( name = "claveTipoMovimiento", nullable = false )
	private String movementTypeKey;
	
	@Column( name = "tipoMovimiento", nullable = false )
	private String movementType;

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "movementType" )
	private Set<WareMovementTotal> wareMovements = new HashSet<>();
	
	public String getMovementTypeKey() {
		return movementTypeKey;
	}

	public void setMovementTypeKey( String movementTypeKey ) {
		this.movementTypeKey = movementTypeKey;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType( String movementType ) {
		this.movementType = movementType;
	}

	public Set<WareMovementTotal> getWareMovements() {
		return wareMovements;
	}

	public void setWareMovements( Set<WareMovementTotal> wareMovements ) {
		this.wareMovements = wareMovements;
	}

}
