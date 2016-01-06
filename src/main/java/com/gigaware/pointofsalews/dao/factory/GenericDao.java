/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dao.factory;

import java.util.List;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 * @param <T> Entity to Save
 */
public interface GenericDao< T > {
    
    void save( T t );
    void saveAll( List<T> ts );
    void update( T t );
    void delete( T t );
    
}
