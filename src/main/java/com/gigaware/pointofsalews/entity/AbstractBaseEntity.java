/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.entity;

import java.io.Serializable;

import com.gigaware.pointofsalews.enumeration.LogicalDeleted;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public abstract class AbstractBaseEntity implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -1633893674191319655L;
	
	private LogicalDeleted logicalDeleted = LogicalDeleted.NO;

	public LogicalDeleted getLogicalDeleted() {
		return logicalDeleted;
	}

	public void setLogicalDeleted(LogicalDeleted logicalDeleted) {
		this.logicalDeleted = logicalDeleted;
	}
	
	
}
