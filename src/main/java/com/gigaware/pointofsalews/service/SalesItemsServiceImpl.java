/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import com.gigaware.pointofsalews.dao.factory.SalesItemDao;
import com.gigaware.pointofsalews.entity.SalesItem;
import java.io.Serializable;
import java.util.List;
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

    @Autowired
    private SalesItemDao salesItemDao;
    
    @Override
    public List<SalesItem> getAll() {
        return ( List<SalesItem> ) salesItemDao.getAll();
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

    /**
     * @param salesItemDao the salesItemDao to set
     */
    public void setSalesItemDao( SalesItemDao salesItemDao ) {
        this.salesItemDao = salesItemDao;
    }
    
    
}
