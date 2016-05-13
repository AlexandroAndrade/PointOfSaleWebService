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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "Categoria", uniqueConstraints = @UniqueConstraint( columnNames = "idCategoriaPadre"))
public class Category implements Serializable {

	/**
	 * AspectJ Generated Version
	 */
	private static final long serialVersionUID = 3471259605555788950L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name = "idCategoria", nullable = false )
	private Long idCategory;
	
	@Column( name = "nombreCategoria", length = 255, nullable = false )
	private String categoryName;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idCategoriaPadre", nullable = false )
	private Category fatherCategory;
	
	@OneToMany( fetch = FetchType.LAZY,  mappedBy = "fatherCategory" )
	private Set<Category> childrenCategories = new HashSet<>();

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "category" )
	private Set<SalesItem> salesItems = new HashSet<>();
	
	/**
	 * @return the idCategory
	 */
	public Long getIdCategory() {
		return idCategory;
	}

	/**
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory( Long idCategory ) {
		this.idCategory = idCategory;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName( String categoryName ) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the fatherCategory
	 */
	public Category getFatherCategory() {
		return fatherCategory;
	}

	/**
	 * @param fatherCategory the fatherCategory to set
	 */
	public void setFatherCategory( Category fatherCategory ) {
		this.fatherCategory = fatherCategory;
	}

	/**
	 * @return the childrenCategories
	 */
	public Set<Category> getChildrenCategories() {
		return childrenCategories;
	}

	/**
	 * @param childrenCategories the childrenCategories to set
	 */
	public void setChildrenCategories( Set<Category> childrenCategories ) {
		this.childrenCategories = childrenCategories;
	}

	/**
	 * @return the salesItems
	 */
	public Set<SalesItem> getSalesItems() {
		return salesItems;
	}

	/**
	 * @param salesItems the salesItems to set
	 */
	public void setSalesItems( Set<SalesItem> salesItems ) {
		this.salesItems = salesItems;
	}

}
