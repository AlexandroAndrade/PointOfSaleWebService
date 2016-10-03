/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gigaware.pointofsalews.dto.movement.damage.WareDamageDTO;
import com.gigaware.pointofsalews.dto.movement.damage.WareDamageResponseDTO;
import com.gigaware.pointofsalews.dto.movement.entry.WareEntryDTO;
import com.gigaware.pointofsalews.dto.movement.entry.WareEntryResponseDTO;
import com.gigaware.pointofsalews.dto.movement.exit.WareExitDTO;
import com.gigaware.pointofsalews.dto.movement.exit.WareExitResponseDTO;
import com.gigaware.pointofsalews.dto.movement.purchase.WarePurchaseDTO;
import com.gigaware.pointofsalews.dto.movement.purchase.WarePurchaseResponseDTO;
import com.gigaware.pointofsalews.dto.movement.waste.WareWasteDTO;
import com.gigaware.pointofsalews.dto.movement.waste.WareWasteResponseDTO;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Path( "/" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public interface WareMovementsWebService {

	@POST
	@Path( "/purchase" )
	WarePurchaseResponseDTO warePurchase( WarePurchaseDTO warePurchase );
	
	@POST
	@Path( "/exit" )
	WareExitResponseDTO wareExit( WareExitDTO wareExit );
	
	@POST
	@Path( "/entry" )
	WareEntryResponseDTO wareEntry( WareEntryDTO wareEntry );

	@POST
	@Path( "/waste" )
	WareWasteResponseDTO wareWaste( WareWasteDTO wareWaste );
	
	@POST
	@Path( "/damage" )
	WareDamageResponseDTO wareDamage( WareDamageDTO wareDamage );
	
}
