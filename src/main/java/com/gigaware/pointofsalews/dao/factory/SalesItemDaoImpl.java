/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao.factory;

import com.gigaware.pointofsalews.constant.QueryConstants;
import com.gigaware.pointofsalews.entity.SalesItem;
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

    @Override
    public List<SalesItem> getAll() {
        return ( List<SalesItem> )
            super.createQuery( QueryConstants.SALESITEM_GET_ALL ).list() ;
    }

    @Override
    public void save( SalesItem t ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAll( List<SalesItem> ts ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update( SalesItem t ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete( SalesItem t ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
