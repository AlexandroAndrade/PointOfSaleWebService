/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sun.xml.txw2.annotation.XmlElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlElement( value = "provider" )
@XmlAccessorType( XmlAccessType.FIELD )
public class ProviderDto implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -1961521802071039782L;
	
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
	public Long getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(Long idProvider) {
		this.idProvider = idProvider;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getTaxPayerIdNumber() {
		return taxPayerIdNumber;
	}
	public void setTaxPayerIdNumber(String taxPayerIdNumber) {
		this.taxPayerIdNumber = taxPayerIdNumber;
	}
	
	
	

	
}
