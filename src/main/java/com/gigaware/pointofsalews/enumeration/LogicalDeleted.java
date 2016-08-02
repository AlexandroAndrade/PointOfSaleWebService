/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.enumeration;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public enum LogicalDeleted {
	
	YES("Y"),
	NO("N");
	
	private String logicalDeleted;
	
	private LogicalDeleted( String logicalDeleted ){
		this.logicalDeleted = logicalDeleted;
	}
	
	@Override
	public String toString(){
		return new ToStringBuilder( "LogicalDeleted : [ ")
			.append( this.logicalDeleted )
			.append(" ].")
			.toString();
	}
}
