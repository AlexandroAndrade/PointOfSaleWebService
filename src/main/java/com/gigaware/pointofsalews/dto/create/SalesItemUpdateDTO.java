/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.create;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.sun.xml.txw2.annotation.XmlElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlElement( value = "salesItemUpdate" )
@XmlAccessorType( XmlAccessType.FIELD )
@JsonIgnoreProperties( ignoreUnknown = true )
public class SalesItemUpdateDTO 
	extends SalesItemCreateDTO
	implements Serializable {
	
	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -1053362724924890816L;
	
	private Long idItem;

	
	public Long getIdItem() {
		return idItem;
	}
	
	public void setIdItem( Long idItem ) {
		this.idItem = idItem;
	}

}
