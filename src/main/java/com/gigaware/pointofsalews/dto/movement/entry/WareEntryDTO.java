/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.movement.entry;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "wareEntry" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WareEntryDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -8908019360392353634L;
	
	private Long idBranch;
	private Long idUser;
	private String movementDate;
	private String remissionNumber;
	
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
	
	public String getRemissionNumber() {
		return remissionNumber;
	}
	
	public void setRemissionNumber( String remissionNumber ) {
		this.remissionNumber = remissionNumber;
	}
	
}
