/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.movement.damage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "wareDamage" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WareDamageResponseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -532309421886903431L;

	private String branchName;
	private String userName;
	private String movementDate;
	private String movementType;
	
	@XmlElement( name = "damagedItems" )
	private List<DamagedItemResponseDTO> damagedItems = new ArrayList<>();

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName( String branchName ) {
		this.branchName = branchName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName( String userName ) {
		this.userName = userName;
	}
	
	public String getMovementDate() {
		return movementDate;
	}

	public void setMovementDate( String movementDate ) {
		this.movementDate = movementDate;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType( String movementType ) {
		this.movementType = movementType;
	}

	public List<DamagedItemResponseDTO> getDamagedItems() {
		return damagedItems;
	}

	public void setDamagedItems( List<DamagedItemResponseDTO> damagedItems ) {
		this.damagedItems = damagedItems;
	}
		
}
