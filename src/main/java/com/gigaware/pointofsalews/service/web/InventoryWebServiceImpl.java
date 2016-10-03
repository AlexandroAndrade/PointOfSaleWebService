/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gigaware.pointofsalews.dto.adjustment.create.AdjustedItemResponseDTO;
import com.gigaware.pointofsalews.dto.adjustment.create.InventoryAdjustmentDTO;
import com.gigaware.pointofsalews.dto.adjustment.create.InventoryAdjustmentResponseDTO;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "inventoryWebService" )
public class InventoryWebServiceImpl implements InventoryWebService, Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 3304801841725416887L;

	@Override
	public InventoryAdjustmentResponseDTO adjustInventory( InventoryAdjustmentDTO inventoryAdjustment ) {
		InventoryAdjustmentResponseDTO invResponse = new InventoryAdjustmentResponseDTO();
		invResponse.setBranchName( "Bodega 75" );
		invResponse.setUserName( "Roberto Mtz" );
		invResponse.setAdjustmentDate( "2016-10-03T17:45:50" );
		
		final List<AdjustedItemResponseDTO> adjustedItems = new ArrayList<>();
		adjustedItems.add( createAdjustedItem( "45001", "Naranja", 25.75F ) );
		adjustedItems.add( createAdjustedItem( "45002", "Manzana", 33.25F ) );
		adjustedItems.add( createAdjustedItem( "45003", "Plátano", 50.50F ) );
		invResponse.setAdjustedItems( adjustedItems );
		
		return invResponse;
	}
	
	private AdjustedItemResponseDTO createAdjustedItem( String itemKey,	String itemName, Float stockFound ) {
		AdjustedItemResponseDTO a = new AdjustedItemResponseDTO();
		a.setItemKey( itemKey );
		a.setItemName( itemName );
		a.setStockFound( stockFound );
		return a;
	}

}
