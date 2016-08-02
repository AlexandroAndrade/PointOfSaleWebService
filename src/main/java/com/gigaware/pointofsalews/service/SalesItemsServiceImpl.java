/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import com.gigaware.pointofsalews.dao.SalesItemDao;
import com.gigaware.pointofsalews.entity.SaleItem;
import com.gigaware.pointofsalews.exception.ExceptionConstant;
import com.gigaware.pointofsalews.exception.PointOfSaleException;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "salesItemsService" )
@Transactional
public class SalesItemsServiceImpl 
    implements SalesItemsService, Serializable {

    /**
	 * AspectJ
	 */
	private static final long serialVersionUID = -6409384080987894544L;
	
	@Autowired
    private SalesItemDao salesItemDao;
    
    @Override
    public List<SaleItem> getAll() {
        return ( List<SaleItem> ) salesItemDao.getAll();
    }
    
	@Override
	public SaleItem getById(Long id) {
		SaleItem item = salesItemDao.getById(id);
		
		if(item == null){
			throw new PointOfSaleException(
					Response.Status.NOT_FOUND, 
					ExceptionConstant.SALES_ITEM_NOT_FOUND_BY_ID_TITLE, 
					String.format( ExceptionConstant.SALES_ITEM_NOT_FOUND_BY_ID_DESCRIPTON, id ) 
					);
		}
		return item;
	}
	
	@Override
	public List<SaleItem> getByInventoryLessThan( Integer inventoryLessThan) {
		return salesItemDao.getByInventoryLessThan( new Float( inventoryLessThan.floatValue() ) );
	}
	
    @Override
    public void save( SaleItem t ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAll( List<SaleItem> ts ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update( SaleItem t ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete( SaleItem t ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param salesItemDao the salesItemDao to set
     */
    public void setSalesItemDao( SalesItemDao salesItemDao ) {
        this.salesItemDao = salesItemDao;
    }

}