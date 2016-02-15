/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.wrapper;

import com.gigaware.pointofsalews.dto.SalesItemDto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlRootElement( name = "SalesItems ")
@XmlAccessorType( XmlAccessType.FIELD )  
public class SalesItemWrapper {
    
    @XmlElement( name = "salesItems" )
    private List<SalesItemDto> salesItems = new ArrayList<>();

	public List<SalesItemDto> getSalesItems() {
		return salesItems;
	}

	public void setSalesItems(List<SalesItemDto> salesItems) {
		this.salesItems = salesItems;
	}
    
    
    
}
