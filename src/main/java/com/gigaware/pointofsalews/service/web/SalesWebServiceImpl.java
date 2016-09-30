/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.gigaware.pointofsalews.dto.sale.create.CreateSaleDTO;
import com.gigaware.pointofsalews.dto.sale.create.ItemForTicketDTO;
import com.gigaware.pointofsalews.dto.sale.create.RegisteredSaleDTO;
import com.gigaware.pointofsalews.dto.sale.read.SaleDTO;
import com.gigaware.pointofsalews.dto.sale.read.SaleDetailsDTO;
import com.gigaware.pointofsalews.dto.sale.read.SoldItemDetailsDTO;
import com.gigaware.pointofsalews.dto.sale.read.TotalSalesDTO;
import com.gigaware.pointofsalews.exception.PointOfSaleException;
import com.google.appengine.repackaged.com.google.protos.gdata.proto2api.Core.Response.ResponseCode;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "salesWebService" )
public class SalesWebServiceImpl implements SalesWebService, Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = -6308213180817746330L;

	@Override
	public RegisteredSaleDTO registerSale( CreateSaleDTO saleDTO ) {
		
		throw new PointOfSaleException( Response.Status.BAD_REQUEST, "Empty Required Fields", "idBranch field is Empty" );
		
//		final RegisteredSaleDTO regSale = new RegisteredSaleDTO();
//		regSale.setBranchName( "Comercial Treviño de Saltillo" );
//		regSale.setTicketNumber( "01-01-00001" );
//		regSale.setSaleDate( "2016-09-29T13:15:54" );
//		
//		final List<ItemForTicketDTO> soldItems = new ArrayList<>();
//		soldItems.add( createSoldItem( 3F, "Cloralex Blanqueador Líquido Aroma Limón 3.8 Lts.", 24.90F, 3.98F ) );
//		soldItems.add( createSoldItem( 5F, "Cloralex Mascotas Reg 950ml",                       17.50F, 2.80F ) );
//		regSale.setSoldItems( soldItems );
//		
//		regSale.setTotalNetPrice( 162.20F );
//		regSale.setTotalTaxes( 25.95F );
//		regSale.setIncome( 200F );
//		regSale.setChange( 11.85F );
//		regSale.setCashierName( "Caja_03" );
//		regSale.setUserName( "Laura Sanchez" );
//		
//		return regSale;
		
	}
	
//	private ItemForTicketDTO createSoldItem( Float quantity, String itemName, Float netPrice, Float tax) {
//		ItemForTicketDTO s = new ItemForTicketDTO();
//		s.setQuantity( quantity );
//		s.setItemName( itemName );
//		s.setNetPrice( netPrice );
//		s.setTax( tax );
//		return s;
//	}

	@Override
	public TotalSalesDTO getSales( Long idBranch, String startDate, String endDate, Long idCashier, Long idUser ) {
		
//		throw new PointOfSaleException( Response.Status.BAD_REQUEST, "Error in Date Fields", "endDate is greater than startDate" );
		
		final TotalSalesDTO totalSales = new TotalSalesDTO();
		totalSales.setIdSaleTotal( 2L );
		totalSales.setBranchName( "Bodega 47" );
		totalSales.setStartDate( "2016-09-29T12:00:00" );
		totalSales.setEndDate(   "2016-09-29T18:00:00" );
		
		final List<SaleDTO> sales = new ArrayList<>();
		sales.add( createSale( "01-01-00001", "2016-09-29T13:15:54", "Laura Sanchez", "Caja_03", 162.2F, 25.95F, 200F ) );
		sales.add( createSale( "01-01-00002", "2016-09-29T13:18:33", "Laura Sanchez", "Caja_03", 4999F , 798.4F, 5797.4F ) );
		totalSales.setSales( sales );
		
		totalSales.setNetTotal(   5161.2F  );
		totalSales.setTotalTaxes(  824.35F );
		totalSales.setGrandTotal( 5985.55F );

		return totalSales;
		
	}
	
	private SaleDTO createSale(	String ticketNumber, String saleDate, String cashierName, String userName,
			Float netTotal, Float totalTaxes, Float paymentAmount) {
		SaleDTO s = new SaleDTO();
		s.setTicketNumber( ticketNumber );
		s.setSaleDate( saleDate );
		s.setCashierName( cashierName );
		s.setUserName( userName );
		s.setNetTotal( netTotal );
		s.setTotalTaxes( totalTaxes );
		s.setPaymentAmount( paymentAmount );
		return s;
	}
	


	@Override
	public SaleDetailsDTO getSaleDetails( Long idSaleTotal ) {
		
		throw new PointOfSaleException( Response.Status.BAD_REQUEST, "No Total Sale Found", "No Total Sale found for Id -> [2]." );
		
//		SaleDetailsDTO saleDetails = new SaleDetailsDTO();
//		saleDetails.setBranchName( "Bodega 47" );
//		saleDetails.setTicketNumber( "01-01-00002" );
//		saleDetails.setSaleDate( "2016-09-29T13:18:33" );
//		saleDetails.setCashierName( "Caja_03" );
//		saleDetails.setUserName( "Laura Sanchez" );
//		saleDetails.setNetTotal( 4999F );
//		saleDetails.setTotalTaxes( 798.4F );
//		saleDetails.setPaymentAmount( 5800F );
//		
//		final List<SoldItemDetailsDTO> soldItems = new ArrayList<>();
//		soldItems.add( createSoldItem( "Marlboro Rojo 10pz",   10F, 412.90F, 499F, 79.84F ) );
//		soldItems.add( createSoldItem( "Marlboro Blanco 10pz", 10F, 412.90F, 499F, 79.84F ) );
//		saleDetails.setSoldItems( soldItems );
//		
//		return saleDetails;
	}
	
//	private SoldItemDetailsDTO createSoldItem( 	String itemName, Float quantity, Float averageCost, Float salePrice, Float tax ) {
//		SoldItemDetailsDTO s = new SoldItemDetailsDTO();
//		s.setItemName( itemName );
//		s.setQuantity( quantity );
//		s.setAverageCost( averageCost );
//		s.setSalePrice( salePrice );
//		s.setTax( tax );
//		return s;
//	}
	
}
