/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.gigaware.pointofsalews.dto.movement.damage.DamagedItemResponseDTO;
import com.gigaware.pointofsalews.dto.movement.damage.WareDamageDTO;
import com.gigaware.pointofsalews.dto.movement.damage.WareDamageResponseDTO;
import com.gigaware.pointofsalews.dto.movement.entry.WareEntryDTO;
import com.gigaware.pointofsalews.dto.movement.entry.WareEntryResponseDTO;
import com.gigaware.pointofsalews.dto.movement.exit.ItemForExitResponseDTO;
import com.gigaware.pointofsalews.dto.movement.exit.WareExitDTO;
import com.gigaware.pointofsalews.dto.movement.exit.WareExitResponseDTO;
import com.gigaware.pointofsalews.dto.movement.purchase.PurchasedItemResponseDTO;
import com.gigaware.pointofsalews.dto.movement.purchase.WarePurchaseDTO;
import com.gigaware.pointofsalews.dto.movement.purchase.WarePurchaseResponseDTO;
import com.gigaware.pointofsalews.dto.movement.waste.WareWasteDTO;
import com.gigaware.pointofsalews.dto.movement.waste.WareWasteResponseDTO;
import com.gigaware.pointofsalews.dto.movement.waste.WastedItemResponseDTO;
import com.gigaware.pointofsalews.exception.PointOfSaleException;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "wareMovementsWebService")
public class WareMovementsWebServiceImpl implements WareMovementsWebService, Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 8521208650759615430L;

	@Override
	public WarePurchaseResponseDTO warePurchase( WarePurchaseDTO warePurchase ) {
		return null;
	}

	@Override
	public WareExitResponseDTO wareExit( WareExitDTO wareExit ) {
		return null;
	}
	
	@Override
	public WareEntryResponseDTO wareEntry( WareEntryDTO wareEntry ) {
		return null;
	}
	
	@Override
	public WareWasteResponseDTO wareWaste( WareWasteDTO wareWaste ) {
		return null;
	}
	
	@Override
	public WareDamageResponseDTO wareDamage( WareDamageDTO wareDamage ) {
		return null;
	}
	
}
