/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import com.gigaware.pointofsalews.constant.QueryConstants;
import com.gigaware.pointofsalews.dao.factory.AbstractHibernateDao;
import com.gigaware.pointofsalews.entity.SaleItem;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Repository( "salesItemDao" )
public class SalesItemDaoImpl 
    extends AbstractHibernateDao 
    implements SalesItemDao, Serializable{

    /**
	 * AspectJ
	 */
	private static final long serialVersionUID = 394532901339539555L;

	@Override
	@SuppressWarnings("unchecked")
    public List<SaleItem> getAll() {
        return ( List<SaleItem> )
            super.createQuery( QueryConstants.SALESITEM_GET_ALL ).list() ;
    }
    
	@Override
	public SaleItem getById(Long id) {
		return (SaleItem)
				super.createQuery(QueryConstants.SALESITEM_GET_BY_ID)
					 .setParameter("idItem", id)
					 .uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SaleItem> getByInventoryLessThan(Float inventoryLessThan) {
		return super.createQuery( QueryConstants.SALESITEM_GET_BY_INVENTORY_LESS_THAN )
					.setParameter("inventory", inventoryLessThan)
					.list();
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

}