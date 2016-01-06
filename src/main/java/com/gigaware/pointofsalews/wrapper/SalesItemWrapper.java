/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.wrapper;

import com.gigaware.pointofsalews.entity.SalesItem;
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
    private List<SalesItem> salesItems =
            new ArrayList<>();

    /**
     * @return the salesItems
     */
    public List<SalesItem> getSalesItems() {
        return salesItems;
    }

    /**
     * @param salesItems the salesItems to set
     */
    public void setSalesItems( List<SalesItem> salesItems ) {
        this.salesItems = salesItems;
    }
    
    
    
}
