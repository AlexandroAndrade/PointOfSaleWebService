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
public class User extends AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -2925621506058335921L;

	private Long idUser;
	private String nickName;
	private String password;
	private Set<SaleTotal> sales = new HashSet<>();
	private Set<InventoryAdjustmentTotal> inventoryAdjustments = new HashSet<>();
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
