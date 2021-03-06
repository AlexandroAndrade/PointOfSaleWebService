/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Path( "/" )
@WebService( name = "helloWorldWebService" )
public interface HelloWorldService {
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	@Path( "/hello" )
	String helloWorld();
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	@Path( "/systemProperty" )
	String getSystemProperty();
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	@Path( "/createSaleItems/{n}" )
	String createSaleItems( @PathParam( "n" ) int n );

}
