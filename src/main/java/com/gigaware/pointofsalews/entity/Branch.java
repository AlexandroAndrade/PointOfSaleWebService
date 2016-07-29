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
//@Entity
//@Table( name = "Marca", uniqueConstraints = 
//		@UniqueConstraint( columnNames = "nombreMarca")
//)
public class Branch implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = 65529935346105746L;

//	@Id
//	@GeneratedValue( strategy = GenerationType.IDENTITY )
//	@Column( name = "idMarca", nullable = false)
	private Long idBranch;
	
	private String branchKey;
	
//	@Column( name = "nombreMarca", nullable = false, length = 45)
	private String branchName;
	
	private Set<Inventory> inventory = new HashSet<>();
	
	public Long getIdBranch() {
		return idBranch;
	}
	
	public void setIdBranch(Long idBranch) {
		this.idBranch = idBranch;
	}
	
	public String getBranchKey() {
		return branchKey;
	}

	public void setBranchKey(String branchKey) {
		this.branchKey = branchKey;
	}

	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Set<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}

}