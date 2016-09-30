/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.sale.read;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "totalSales" )
@XmlAccessorType( XmlAccessType.FIELD )
public class TotalSalesDTO implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 1255909784569148910L;

	private Long idSaleTotal;
	private String branchName;
	private String startDate;
	private String endDate;
	
	@XmlElement( name = "sales" )
	private List<SaleDTO> sales = new ArrayList<>();
	
	private Float netTotal;
	private Float totalTaxes;
	private Float grandTotal;
	
	public Long getIdSaleTotal() {
		return idSaleTotal;
	}

	public void setIdSaleTotal( Long idSaleTotal ) {
		this.idSaleTotal = idSaleTotal;
	}

	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName( String branchName ) {
		this.branchName = branchName;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate( String startDate ) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate( String endDate ) {
		this.endDate = endDate;
	}
	
	public List<SaleDTO> getSales() {
		return sales;
	}
	
	public void setSales( List<SaleDTO> sales ) {
		this.sales = sales;
	}
	
	public Float getNetTotal() {
		return netTotal;
	}
	
	public void setNetTotal( Float netTotal ) {
		this.netTotal = netTotal;
	}
	
	public Float getTotalTaxes() {
		return totalTaxes;
	}
	
	public void setTotalTaxes( Float totalTaxes ) {
		this.totalTaxes = totalTaxes;
	}
	
	public Float getGrandTotal() {
		return grandTotal;
	}
	
	public void setGrandTotal( Float grandTotal ) {
		this.grandTotal = grandTotal;
	}

}
