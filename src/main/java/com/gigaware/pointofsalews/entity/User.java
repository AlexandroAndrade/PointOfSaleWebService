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
@Table( name = "Usuario", uniqueConstraints = 
	@UniqueConstraint( columnNames = "nickname" )
)
public class User extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -2925621506058335921L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "idUsuario", nullable = false )
	private Long idUser;
	
	@Column( name = "nickname", nullable = false )
	private String nickName;
	
	@Column( name = "password", nullable = false )
	private String password;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "user" )
	private Set<SaleTotal> sales = new HashSet<>();
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "user" )
	private Set<InventoryAdjustmentTotal> inventoryAdjustments = new HashSet<>();

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "user" )
	private Set<WareMovementTotal> wareMovements = new HashSet<>();

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser( Long idUser ) {
		this.idUser = idUser;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName( String nickName ) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public Set<SaleTotal> getSales() {
		return sales;
	}

	public void setSales( Set<SaleTotal> sales ) {
		this.sales = sales;
	}

	public Set<InventoryAdjustmentTotal> getInventoryAdjustments() {
		return inventoryAdjustments;
	}

	public void setInventoryAdjustments( Set<InventoryAdjustmentTotal> inventoryAdjustments ) {
		this.inventoryAdjustments = inventoryAdjustments;
	}

	public Set<WareMovementTotal> getWareMovements() {
		return wareMovements;
	}

	public void setWareMovements( Set<WareMovementTotal> wareMovements ) {
		this.wareMovements = wareMovements;
	}

}
