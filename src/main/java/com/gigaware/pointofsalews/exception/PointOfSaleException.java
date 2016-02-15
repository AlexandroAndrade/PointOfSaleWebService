/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.exception;

import java.io.Serializable;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
* @author Alex Andrade ( yngwie_alex@hotmail.com )
*/
public class PointOfSaleException 
	extends WebApplicationException 
	implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 2106301173736099338L;
	
	public PointOfSaleException(
			Response.Status statusErrorCode,  
			String errorTitle, 
			String errorMessage ){
		
		super(Response
				.status(statusErrorCode)
				.entity(new ItemException(
								statusErrorCode, 
								errorTitle, 
								errorMessage))
				.type( MediaType.APPLICATION_JSON)
				.build()
			);
	}
	

}
