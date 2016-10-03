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
public class InventoryAdjustmentDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -5630319891317669341L;
	
	private Long idBranch;
	private Long idUser;
	private String adjustmentDate;
	
	@XmlElement( name = "adjustedItems" )
	private List<AdjustedItemDTO> adjustedItems = new ArrayList<>();

	public Long getIdBranch() {
		return idBranch;
	}

	public void setIdBranch( Long idBranch ) {
		this.idBranch = idBranch;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser( Long idUser ) {
		this.idUser = idUser;
	}

	public String getAdjustmentDate() {
		return adjustmentDate;
	}

	public void setAdjustmentDate( String adjustmentDate ) {
		this.adjustmentDate = adjustmentDate;
	}

	public List<AdjustedItemDTO> getAdjustedItems() {
		return adjustedItems;
	}

	public void setAdjustedItems( List<AdjustedItemDTO> adjustedItems ) {
		this.adjustedItems = adjustedItems;
	}
	
}
