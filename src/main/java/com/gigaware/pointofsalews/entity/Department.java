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
public class Department extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 3471259605555788950L;

	private Long idDepartment;
	private String departmentName;
	private Set<SaleItem> salesItems = new HashSet<>();

	public Long getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment( Long idDepartment ) {
		this.idDepartment = idDepartment;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName( String departmentName ) {
		this.departmentName = departmentName;
	}

	public Set<SaleItem> getSalesItems() {
		return salesItems;
	}

	public void setSalesItems( Set<SaleItem> salesItems ) {
		this.salesItems = salesItems;
	}

}
