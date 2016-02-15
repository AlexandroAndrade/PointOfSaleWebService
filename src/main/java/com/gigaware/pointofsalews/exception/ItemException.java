/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.exception;

import java.io.Serializable;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
* @author Alex Andrade ( yngwie_alex@hotmail.com )
*/
@XmlRootElement( name = "error")
@XmlAccessorType( XmlAccessType.FIELD )
public class ItemException implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -5188982334252109258L;
	
	private Response.Status errorCode;
	private String errorName;
	private String errorDescription;
	
	public ItemException( Response.Status errorCode, String errorName, String errorDescription) {
		this.errorCode = errorCode;
		this.errorName = errorName;
		this.errorDescription = errorDescription;
	}
	
	
	public Response.Status getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Response.Status errorCode) {
		this.errorCode = errorCode;
	}



	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	

	
	

}
