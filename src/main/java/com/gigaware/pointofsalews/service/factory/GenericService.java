/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.factory;

import java.util.List;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 * @param <T> Business Entity
 * @param <D> Dto for Creating and Modifying
 * @param <R> Class for Responses
 */
public interface GenericService< T, D > {
	
	List<T> getAll();
	T getById(Long id);
	 
	T save( D d );
    void saveAll( List<D> ds );
    void update( T t );
    void delete( T t );

}