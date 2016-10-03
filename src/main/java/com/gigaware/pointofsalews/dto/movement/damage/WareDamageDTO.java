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
public class WareDamageDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -4186046984164565437L;
	
	private Long idBranch;
	private Long idUser;
	private String movementDate;
	
	@XmlElement( name = "damagedItems" )
	private List<DamagedItemDTO> damagedItems = new ArrayList<>();

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

	public String getMovementDate() {
		return movementDate;
	}

	public void setMovementDate( String movementDate ) {
		this.movementDate = movementDate;
	}

	public List<DamagedItemDTO> getDamagedItems() {
		return damagedItems;
	}

	public void setDamagedItems( List<DamagedItemDTO> damagedItems ) {
		this.damagedItems = damagedItems;
	}
	
}
