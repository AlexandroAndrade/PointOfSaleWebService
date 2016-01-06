/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Entity
@Table( name = "articulo", uniqueConstraints = 
        @UniqueConstraint( columnNames = "nombre")
)
public class SalesItem implements Serializable {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idArticulo" , nullable = false )
    private Long id;
    
    @Column( name = "nombre", length = 45, nullable = false )
    private String itemName;
    
    @Column( name = "precioVenta", nullable = false )
    private Float salePrice;
    
    @Column( name = "costoPromedio", nullable = false )
    private Float averageCost;
    
    @Column( name = "existencias", nullable = false )
    private Float inventory;
    
    @Column( name = "codigoBarras", length = 45, nullable = true )
    private String codeBar;
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId( Long id ) {
        this.id = id;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName( String itemName ) {
        this.itemName = itemName;
    }

    /**
     * @return the salePrice
     */
    public Float getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice the salePrice to set
     */
    public void setSalePrice( Float salePrice ) {
        this.salePrice = salePrice;
    }

    /**
     * @return the averageCost
     */
    public Float getAverageCost() {
        return averageCost;
    }

    /**
     * @param averageCost the averageCost to set
     */
    public void setAverageCost( Float averageCost ) {
        this.averageCost = averageCost;
    }

    /**
     * @return the inventory
     */
    public Float getInventory() {
        return inventory;
    }

    /**
     * @param inventory the inventory to set
     */
    public void setInventory( Float inventory ) {
        this.inventory = inventory;
    }

    /**
     * @return the codeBar
     */
    public String getCodeBar() {
        return codeBar;
    }

    /**
     * @param codeBar the codeBar to set
     */
    public void setCodeBar( String codeBar ) {
        this.codeBar = codeBar;
    }
    
    
    
}
