/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.io.Serializable;

import org.springframework.stereotype.Service;

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
		return null;
	}
	
}
