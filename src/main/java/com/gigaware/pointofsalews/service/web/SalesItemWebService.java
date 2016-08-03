/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import com.gigaware.pointofsalews.dto.SalesItemDto;
import com.gigaware.pointofsalews.dto.create.SalesItemCreateAndModifyDTO;
import com.gigaware.pointofsalews.wrapper.SalesItemWrapper;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Path( "/" )
@WebService ( name = "salesItemWebService")
public interface SalesItemWebService {
    
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/all" )
    SalesItemWrapper getAllSalesItems();
    
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/{idItem}" )
    SalesItemDto getItemById(@PathParam("idItem") Long idItem);
    
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/{inventory}/inventory" )
    SalesItemWrapper getByInventoryLessThan( 
    		@PathParam( "inventory" ) Integer inventory );
    
    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/save" )
    SalesItemWrapper saveItem( SalesItemCreateAndModifyDTO saleItem );
    
}
