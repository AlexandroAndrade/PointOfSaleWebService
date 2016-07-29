/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.io.Serializable;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
public class HelloWorldServiceImpl 
	implements HelloWorldService, Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -2970873301857903034L;
	
	@Override
	public String helloWorld() {
		return "Hello World !!!";
	}
	

}
