/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import com.gigaware.pointofsalews.dto.SalesItemDto;
import com.gigaware.pointofsalews.dto.item.create.SalesItemCreateDTO;
import com.gigaware.pointofsalews.dto.item.create.SalesItemUpdateDTO;
import com.gigaware.pointofsalews.wrapper.SalesItemWrapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Path( "/" )
public interface SalesItemWebService {
    
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/all" )
    SalesItemWrapper getAllSalesItems();
    
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/{idItem}" )
    SalesItemDto getItemById( @PathParam( "idItem" ) Long idItem );
    
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/itemKey/{key}" )
    SalesItemDto getItemByItemKey(@PathParam( "key" ) String itemKey );
    
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/{inventory}/inventory" )
    SalesItemWrapper getByInventoryLessThan( 
    		@PathParam( "inventory" ) Integer inventory );
    
    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/save" )
    SalesItemWrapper saveItem( SalesItemCreateDTO saleItem );

    @PUT
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/update" )
    SalesItemWrapper updateItem( SalesItemUpdateDTO saleItem );
    
    @DELETE
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/{idItem}" )
    SalesItemDto deleteItem( @PathParam( "idItem" ) Long idItem );
    
    
}
