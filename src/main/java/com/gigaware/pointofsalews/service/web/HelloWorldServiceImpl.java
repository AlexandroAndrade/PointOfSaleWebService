/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.io.Serializable;
import java.util.Map;

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
		for( Map.Entry<Object, Object> prop : System.getProperties().entrySet() ){
			sb.append( prop.getKey().toString() + " -> " + prop.getValue().toString() + " \n");
		}
		return sb.toString();

	}
	

}
