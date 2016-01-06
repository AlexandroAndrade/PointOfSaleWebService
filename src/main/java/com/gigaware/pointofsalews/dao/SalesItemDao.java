/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao;

import com.gigaware.pointofsalews.dao.factory.GenericDao;
import com.gigaware.pointofsalews.entity.SalesItem;
import java.util.List;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public interface SalesItemDao extends GenericDao<SalesItem>{
    
    List<SalesItem> getAll();
    
}
