/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.gigaware.pointofsalews.dto.create.CreateSaleDTO;
import com.gigaware.pointofsalews.dto.read.RegisteredSalesWrapper;
import com.gigaware.pointofsalews.dto.response.RegisteredSaleDTO;
import com.gigaware.pointofsalews.dto.response.RegisteredSaleDetailsDTO;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Path( "/" )
public interface SalesWebService {

	@POST
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	@Path( "/register" )
	RegisteredSaleDTO registerSale( CreateSaleDTO saleDTO );
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	@Path( "/get-sales")
	RegisteredSalesWrapper getSales( 
			@QueryParam( value = "idBranch" ) Long idBranch,
			@QueryParam( value = "startDate") String startDate,
			@QueryParam( value = "endDate") String endDate,
			@QueryParam( value = "idCashier") Long idCashier,
			@QueryParam( value = "idUser") Long idUser );
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	@Path( "/get-sale-details")
	RegisteredSaleDetailsDTO getSaleDetails( 
			@PathParam( value = "idSaleTotal" ) Long idSaleTotal );
	
}
