/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.movement.entry;

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
@XmlRootElement( name = "wareEntry" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WareEntryResponseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 1570652304572464544L;

	private String branchName;
	private String userName;
	private String movementDate;
	private String movementType;
	private String remissionNumber;
	
	@XmlElement( name = "entryItems" )
	private List<ItemForEntryResponseDTO> entryItems = new ArrayList<>();

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

	public String getRemissionNumber() {
		return remissionNumber;
	}

	public void setRemissionNumber( String remissionNumber ) {
		this.remissionNumber = remissionNumber;
	}

	public List<ItemForEntryResponseDTO> getEntryItems() {
		return entryItems;
	}

	public void setEntryItems( List<ItemForEntryResponseDTO> entryItems ) {
		this.entryItems = entryItems;
	}
	
}
