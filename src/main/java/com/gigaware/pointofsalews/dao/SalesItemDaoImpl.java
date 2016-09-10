/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import com.gigaware.pointofsalews.constant.PosConstants;
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
public class SalesItemDaoImpl extends AbstractHibernateDao implements SalesItemDao, Serializable {

    /**
	 * AspectJ
	 */
	private static final long serialVersionUID = 394532901339539555L;

	@Override
	@SuppressWarnings( "unchecked" )
    public List<SaleItem> getAll() {
        return ( List<SaleItem> )
            super.createQuery( QueryConstants.SALESITEM_GET_ALL ).list() ;
    }
    
	@Override
	public SaleItem getById(Long id) {
		return ( SaleItem )
				super.createQuery(QueryConstants.SALESITEM_GET_BY_ID)
					 .setParameter("idItem", id)
					 .uniqueResult();
	}
	
	@Override
	@SuppressWarnings( "unchecked" )
	public List<SaleItem> getDifferent( String itemName, String codeBars ) {
		return super.createQuery( QueryConstants.SALESITEM_GET_DIFFERENT )
				 .setParameter( "itemName", itemName )
				 .setParameter( "codeBars", codeBars )
				 .list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SaleItem> getByInventoryLessThan(Float inventoryLessThan) {
		return super.createQuery( QueryConstants.SALESITEM_GET_BY_INVENTORY_LESS_THAN )
					.setParameter("inventory", inventoryLessThan)
					.list();
	}

	@Override
	public SaleItem getByItemKey( String itemKey ) {
		return ( SaleItem )
				super.createQuery( QueryConstants.SALESITEM_GET_BY_ITEMKEY )
					 .setString( "itemKey", itemKey )
					 .uniqueResult();
	}
	
	@Override
	public SaleItem getByItemName( String itemName ) {
		return ( SaleItem )
				super.createQuery( QueryConstants.SALESITEM_GET_BY_ITEMNAME )
					 .setString( "itemName", itemName )
					 .uniqueResult();
	}
	
	@Override
	public SaleItem getByCodeBars( String codeBars ) {
		return ( SaleItem )
				super.createQuery( QueryConstants.SALESITEM_GET_BY_CODBARS )
					 .setString( "codeBars", codeBars )
					 .uniqueResult();
	}
	
    @Override
    public void save( SaleItem saleItem ) {
    	getSessionFactory().getCurrentSession().persist( saleItem );
    }

    @Override
    public void saveAll( List<SaleItem> saleItems ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update( SaleItem saleItem ) {
    	getSessionFactory().getCurrentSession().merge( saleItem );
    }

    @Override
    public void delete( SaleItem saleItem ) {
    	saleItem.setLogicalDeleted( PosConstants.LOGICAL_DELETED_YES );
    	getSessionFactory().getCurrentSession().update( saleItem );
    }

}