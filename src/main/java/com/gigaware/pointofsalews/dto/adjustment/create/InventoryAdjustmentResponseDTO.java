/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.adjustment.create;

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
@XmlRootElement( name = "inventoryAdjustment" )
@XmlAccessorType( XmlAccessType.FIELD )
public class InventoryAdjustmentResponseDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -6831565538099223637L;
	
	private String branchName;
	private String userName;
	private String adjustmentDate;
	
	@XmlElement( name = "adjustedItems" )
	private List<AdjustedItemResponseDTO> adjustedItems = new ArrayList<>();

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

	public String getAdjustmentDate() {
		return adjustmentDate;
	}

	public void setAdjustmentDate( String adjustmentDate ) {
		this.adjustmentDate = adjustmentDate;
	}

	public List<AdjustedItemResponseDTO> getAdjustedItems() {
		return adjustedItems;
	}

	public void setAdjustedItems( List<AdjustedItemResponseDTO> adjustedItems ) {
		this.adjustedItems = adjustedItems;
	}

}
