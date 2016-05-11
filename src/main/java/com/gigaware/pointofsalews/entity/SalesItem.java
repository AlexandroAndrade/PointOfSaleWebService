/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "articulo", uniqueConstraints = {
        @UniqueConstraint( columnNames = "nombreArticulo"),
        @UniqueConstraint( columnNames = "codigoBarras")
		}
)
public class SalesItem implements Serializable {
    
    /**
	 * AspectJ
	 */
	private static final long serialVersionUID = -9197884745195157740L;

	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idArticulo" , nullable = false )
    private Long idItem;
    
    @Column( name = "nombreArticulo", length = 100, nullable = false )
    private String itemName;
    
    @Column( name = "precioVenta", nullable = false )
    private Float salePrice;
    
    @Column( name = "costoPromedio", nullable = false )
    private Float averageCost;
    
    @Column( name = "existencias", nullable = false )
    private Float inventory;
    
    @Column( name = "codigoBarras", length = 45, nullable = true )
    private String codeBar;
    
    
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "idMarca", nullable = false )
    private Branch branch;
    
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "idProveedor", nullable = false )
    private Provider provider;
    
    public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public String getItemName() {
        return itemName;
    }

    public void setItemName( String itemName ) {
        this.itemName = itemName;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice( Float salePrice ) {
        this.salePrice = salePrice;
    }

    public Float getAverageCost() {
        return averageCost;
    }

    public void setAverageCost( Float averageCost ) {
        this.averageCost = averageCost;
    }

    public Float getInventory() {
        return inventory;
    }

    public void setInventory( Float inventory ) {
        this.inventory = inventory;
    }

    public String getCodeBar() {
        return codeBar;
    }

    public void setCodeBar( String codeBar ) {
        this.codeBar = codeBar;
    }

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

}