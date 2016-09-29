/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.gigaware.pointofsalews.dto.create.CreateSaleDTO;
import com.gigaware.pointofsalews.dto.read.RegisteredSalesWrapper;
import com.gigaware.pointofsalews.dto.response.RegisteredSaleDTO;
import com.gigaware.pointofsalews.dto.response.RegisteredSaleDetailsDTO;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisteredSalesWrapper getSales( Long idBranch, String startDate, String endDate, Long idCashier,
			Long idUser ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisteredSaleDetailsDTO getSaleDetails( Long idSaleTotal ) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
