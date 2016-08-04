/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.io.Serializable;

import org.springframework.stereotype.Service;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "helloWorldWebService")
public class HelloWorldServiceImpl 
	implements HelloWorldService, Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -2970873301857903034L;
	
	@Override
	public String helloWorld() {
		return "Hola Chiki, te quiero (F) !!!";
	}
	
	@Override
	public String getSystemProperty() {
		final StringBuilder sb = new StringBuilder();
		sb.append( "[ com.google.appengine.runtime.version ] : " )
		  .append( System.getProperty( "com.google.appengine.runtime.version" ) )
		  .append( "\n")
		  .append( "[ ae-cloudsql.cloudsql-database-url ] : " )
		  .append( System.getProperty( "ae-cloudsql.cloudsql-database-url" ) ) 
		  .append( "\n" )
		  .append( " [ ae-cloudsql.local-database-url ] : " )
		  .append( System.getProperty( "ae-cloudsql.local-database-url" ) )
		  .append( "\n" ).toString();
		return null;

	}
	

}
