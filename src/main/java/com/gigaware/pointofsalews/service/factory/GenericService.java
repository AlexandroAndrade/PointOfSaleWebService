/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.factory;

import java.util.List;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 * @param <T> Business Entity
 * @param <C> DTO Class for Creating a new SaleItem
 * @param <U> DTO Class for Updating a new SaleItem
 */
public interface GenericService< T, C, U > {
	
	List<T> getAll();
	T getById(Long id);
	 
	T save( C c );
    void saveAll( List<C> cs );
    T update( U u );
    T delete( Long id );

}