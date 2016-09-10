/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.apache.commons.lang3.StringUtils;

import com.gigaware.pointofsalews.constant.PosConstants;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -1633893674191319655L;
	
	@Column( name = "borradoLogico", length = 1, nullable = false )
	private String logicalDeleted = PosConstants.LOGICAL_DELETED_NO;

	public String getLogicalDeleted() {
		return logicalDeleted;
	}

	public void setLogicalDeleted( String logicalDeleted ) {
		this.logicalDeleted = logicalDeleted;
	}

	@PrePersist
	void beforePersist(){
		if( StringUtils.isEmpty( this.logicalDeleted )){
			this.logicalDeleted = PosConstants.LOGICAL_DELETED_NO;
		} else if ( this.logicalDeleted.length() > 1 ) {
			this.logicalDeleted= PosConstants.LOGICAL_DELETED_NO;
		}
	}
	
}
