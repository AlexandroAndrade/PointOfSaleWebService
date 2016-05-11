/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "Proveedor", uniqueConstraints = {
		@UniqueConstraint( columnNames = "nombreProveedor" ),
		@UniqueConstraint( columnNames = "razonSocial" ),
		@UniqueConstraint( columnNames = "rfc" )
})
public class Provider implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 8242913122958554122L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "idProveedor", nullable = false)
	private Long idProvider;
	
	@Column( name = "nombreProveedor" , nullable = false, length = 255 )
	private String providerName;
	
	@Column( name = "direccion", nullable = false, length = 255 )
	private String address;
	
	@Column ( name = "telefono", nullable = false, length = 45 )
	private String phoneNumber;
	
	@Column( name = "codigoPostal", nullable = false, length = 20 )
	private String postalCode;
	
	@Column( name = "ciudad", nullable = false, length = 45 )
	private String city;

	@Column( name = "estado", nullable = false, length = 45 )
	private String state;

	@Column( name = "pais", nullable = false, length = 45 )
	private String country;

	@Column( name = "razonSocial", nullable = false, length = 45 )
	private String businessName;
	
	@Column( name = "rfc", nullable = false, length = 45 )
	private String taxPayerIdNumber;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "provider" )
	private Set<SalesItem> salesItems = new HashSet<>();

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
	
	public Set<SalesItem> getSalesItems() {
		return salesItems;
	}
	
	public void setSalesItems(Set<SalesItem> salesItems) {
		this.salesItems = salesItems;
	}

}