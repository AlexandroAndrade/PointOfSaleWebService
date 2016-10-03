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
		
//		throw new PointOfSaleException( 
//				Response.Status.BAD_REQUEST, "Incorrect Date Field", "movementDate field doesn't match the [yyyy-mm-ddThh:mm:ss] format." );

		WarePurchaseResponseDTO warePurchaseResponse = new WarePurchaseResponseDTO();
		warePurchaseResponse.setBranchName( "Centro de Distribución" );
		warePurchaseResponse.setUserName( "Roberto Mtz" );
		warePurchaseResponse.setMovementDate( "2016-09-30T20:15:00" );
		warePurchaseResponse.setTotalMovementCost( 4262.50F );
		warePurchaseResponse.setRemissionNumber( "ABAST-COM-TK8610" );
		warePurchaseResponse.setMovementType( "Compra de Mercancía" );
		
		final List<PurchasedItemResponseDTO> purchasedItems = new ArrayList<>();
		purchasedItems.add( createPurchasedItem( "CLORB3.8", "Cloralex Blanqueador Líquido Aroma Limón 3.8 Lts.", 100F, 19.75F, 19.73F, 1975F ) );
		purchasedItems.add( createPurchasedItem( "CLORMASC950", "Cloralex Mascotas Reg 950ml", 150F, 15.25F, 15.34F, 2287.50F ) );
		warePurchaseResponse.setPurchasedItems( purchasedItems );
		
		return warePurchaseResponse;
		
	}
	
	private PurchasedItemResponseDTO createPurchasedItem( String itemKey, String itemName, Float quantity, 
			Float cost, Float newAverageCost, Float totalCost ) {
		PurchasedItemResponseDTO p = new PurchasedItemResponseDTO();
		p.setItemKey( itemKey );
		p.setItemName( itemName );
		p.setQuantity( quantity );
		p.setCost( cost );
		p.setNewAverageCost( newAverageCost );
		return p;
	}
	

	@Override
	public WareExitResponseDTO wareExit( WareExitDTO wareExit ) {
//		return null;
		final WareExitResponseDTO wareExitResponse = new WareExitResponseDTO();
		wareExitResponse.setBranchName( "Centro de Distribución" );
		wareExitResponse.setUserName( "Juan Perez" );
		wareExitResponse.setMovementDate( "2016-09-30T21:20:00" );
		wareExitResponse.setRemissionNumber( "CEDIS-01-01-0001" );
		wareExitResponse.setMovementType( "Salida de Mercancía" );
		
		final List<ItemForExitResponseDTO> exitItems = new ArrayList<>();
		exitItems.add( createItemForExit( "CLORDESVIN950", "Cloralex Desmanchador Color Vinagre 950ml", 50F ) );
		exitItems.add( createItemForExit( "CLORDESVIN1.8", "Cloralex Desmanchador Color Vinagre 1.8lt", 75F ) );
		wareExitResponse.setItems( exitItems );
		
		return wareExitResponse;
	}
	
	private ItemForExitResponseDTO createItemForExit( String itemKey,	String itemName, Float exitQuantity ) {
		ItemForExitResponseDTO i = new ItemForExitResponseDTO();
		i.setItemKey( itemKey );
		i.setItemName( itemName );
		i.setExitQuantity( exitQuantity );
		return i;
	}
	
	

	@Override
	public WareEntryResponseDTO wareEntry( WareEntryDTO wareEntry ) {

		throw new PointOfSaleException( 
				Response.Status.BAD_REQUEST, 
				"No Exit Movement Found", 
				"No Exit Movement found for Remission Number -> [CEDIS-01-01-0001]." );

//				
//		WareEntryResponseDTO entryResponse = new WareEntryResponseDTO();
//		entryResponse.setBranchName( "Bodega 50" );
//		entryResponse.setUserName( "Roberto Mtz" );
//		entryResponse.setMovementDate( "2016-10-01T09:15:20" );
//		entryResponse.setMovementType( "Entrada de Mercancía" );
//		entryResponse.setRemissionNumber( "CEDIS-01-01-0001" );
//		
//		final List<ItemForEntryResponseDTO> entryItems = new ArrayList<>();
//		entryItems.add( createItemForEntry( "CLORDESVIN950", "Cloralex Desmanchador Color Vinagre 950ml", 50F ) );
//		entryItems.add( createItemForEntry( "CLORDESVIN1.8", "Cloralex Desmanchador Color Vinagre 1.8lt", 75F ) );
//		entryResponse.setEntryItems( entryItems );
//		
//		return entryResponse;
	}
	
//	private ItemForEntryResponseDTO createItemForEntry( String itemKey, String itemName, Float entryQuantity ) {
//		ItemForEntryResponseDTO i = new ItemForEntryResponseDTO();
//		i.setItemKey( itemKey );
//		i.setItemName( itemName );
//		i.setEntryQuantity( entryQuantity );
//		return i;
//	}

	@Override
	public WareWasteResponseDTO wareWaste( WareWasteDTO wareWaste ) {
		WareWasteResponseDTO wasteResponse = new WareWasteResponseDTO();
		wasteResponse.setBranchName( "Bodega 89" );
		wasteResponse.setUserName( "admin" );
		wasteResponse.setMovementDate( "2016-10-03T16:32:56" );
		wasteResponse.setMovementType( "Merma de Mercancía" );
		
		final List<WastedItemResponseDTO> wastedItems = new ArrayList<>();
		wastedItems.add( createWastedItem( "CLORDESVIN1.8", "Cloralex Desmanchador Color Vinagre 1.8lt", 2F ) );
		wastedItems.add( createWastedItem( "CLORBREG7LT", "Cloralex Blanqueador Regular 7lt", 2F ) );
		wasteResponse.setWastedItems( wastedItems );
		return wasteResponse;
	}
	
	private WastedItemResponseDTO createWastedItem( String itemKey,	String itemName, Float wastedQuantity ) {
		WastedItemResponseDTO w = new WastedItemResponseDTO();
		w.setItemKey( itemKey );
		w.setItemName( itemName );
		w.setWastedQuantity( wastedQuantity );
		return w;
	}
	
	

	@Override
	public WareDamageResponseDTO wareDamage( WareDamageDTO wareDamage ) {
		WareDamageResponseDTO wareDamageResponse = new WareDamageResponseDTO();
		wareDamageResponse.setBranchName( "Bodega 90" );
		wareDamageResponse.setUserName( "Juan Perez" );
		wareDamageResponse.setMovementDate( "2016-10-03T13:56:35" );
		wareDamageResponse.setMovementType( "Daño de Mercancía" );
		
		final List<DamagedItemResponseDTO> damagedItems = new ArrayList<>();
		damagedItems.add( createDamagedItem( "CIGCAM10", "Camel 10pz", 1F ) );
		damagedItems.add( createDamagedItem( "CIGCAM8", "Faros 8pz",   2F ) );
		wareDamageResponse.setDamagedItems( damagedItems );
		return wareDamageResponse;
	}
	
	private DamagedItemResponseDTO createDamagedItem( String itemKey, String itemName, Float damagedQuantity ) {
		DamagedItemResponseDTO d = new DamagedItemResponseDTO();
		d.setItemKey( itemKey );
		d.setItemName( itemName );
		d.setDamagedQuantity( damagedQuantity );
		return d;
	}
	
	
	
	
	
	
	
	

}
