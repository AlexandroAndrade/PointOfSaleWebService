/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.movement.exit;

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
@XmlRootElement( name = "wareExit" )
@XmlAccessorType( XmlAccessType.FIELD )
public class WareExitDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 4715994039483201473L;

	private Long idBranch;
	private Long idUser;
	private String movementDate;
	
	@XmlElement( name = "items" )
	private List<ItemForExitDTO> items = new ArrayList<>();

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

	public List<ItemForExitDTO> getItems() {
		return items;
	}

	public void setItems( List<ItemForExitDTO> items ) {
		this.items = items;
	}

}
