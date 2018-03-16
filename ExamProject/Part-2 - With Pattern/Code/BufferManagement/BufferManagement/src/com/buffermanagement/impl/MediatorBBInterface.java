package com.buffermanagement.impl;

import com.buffermanagement.exception.BBException;

/**
 * Design Pattern: Mediator: The Mediator defines the interface for communication
 * 
 * @author borde
 *
 */
public interface MediatorBBInterface {
	
	int getRequest() throws BBException;
	
	void putRequest(int val) throws BBException;
}
