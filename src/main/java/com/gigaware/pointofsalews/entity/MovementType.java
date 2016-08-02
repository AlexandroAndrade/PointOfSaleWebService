/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class MovementType extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 190509682899340909L;

	private String movementTypeKey;
	private String movementType;

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

}
