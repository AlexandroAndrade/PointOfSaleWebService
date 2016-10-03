/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gigaware.pointofsalews.dto.adjustment.create.InventoryAdjustmentDTO;
import com.gigaware.pointofsalews.dto.adjustment.create.InventoryAdjustmentResponseDTO;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Path( "/" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public interface InventoryWebService {
	
	@POST
	@Path( "/adjust" )
	InventoryAdjustmentResponseDTO adjustInventory( InventoryAdjustmentDTO inventoryAdjustment );
	
	
}
