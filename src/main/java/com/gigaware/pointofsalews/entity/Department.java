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
@Table( name = "departamento" )
public class Department extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 3471259605555788950L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "idDepartamento", nullable = false )
	private Long idDepartment;
	
	@Column( name = "nombreDepartamento", nullable = false )
	private String departmentName;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "department" )
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
