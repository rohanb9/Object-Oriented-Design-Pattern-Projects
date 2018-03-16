package com.buffermanagement.state;

import com.buffermanagement.classes.BoundedBuffer;
import com.buffermanagement.exception.BBException;

/**
 * Design Pattern: State.
 * 
 * @author borde
 *
 */
public interface State {
	
	public int doAction(BoundedBuffer context) throws BBException;
}
