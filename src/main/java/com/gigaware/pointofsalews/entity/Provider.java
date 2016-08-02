/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class Provider extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 8242913122958554122L;

	private Long idProvider;
	private String providerName;
	private String address;
	private String phoneNumber;
	private String postalCode;
	private String city;
	private String state;
	private String country;
	private String businessName;
	private String taxPayerIdNumber;
	private Set<SaleItem> salesItems = new HashSet<>();

	public Long getIdProvider() {
		return idProvider;
	}

	public void setIdProvider( Long idProvider ) {
		this.idProvider = idProvider;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName( String providerName ) {
		this.providerName = providerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress( String address ) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber( String phoneNumber ) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode( String postalCode ) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity( String city ) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState( String state ) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry( String country ) {
		this.country = country;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName( String businessName ) {
		this.businessName = businessName;
	}

	public String getTaxPayerIdNumber() {
		return taxPayerIdNumber;
	}

	public void setTaxPayerIdNumber( String taxPayerIdNumber ) {
		this.taxPayerIdNumber = taxPayerIdNumber;
	}

	public Set<SaleItem> getSalesItems() {
		return salesItems;
	}

	public void setSalesItems( Set<SaleItem> salesItems ) {
		this.salesItems = salesItems;
	}

}