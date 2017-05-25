/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.io.Serializable;
import org.springframework.stereotype.Service;

import com.gigaware.pointofsalews.dto.sale.create.CreateSaleDTO;
import com.gigaware.pointofsalews.dto.sale.create.RegisteredSaleDTO;
import com.gigaware.pointofsalews.dto.sale.read.SaleDetailsDTO;
import com.gigaware.pointofsalews.dto.sale.read.TotalSalesDTO;

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
		return null;
	}
	
	@Override
	public TotalSalesDTO getSales( Long idBranch, String startDate, String endDate, Long idCashier, Long idUser ) {
		return null;
	}
	
	@Override
	public SaleDetailsDTO getSaleDetails( Long idSaleTotal ) {
		return null;
	}
	
}
