package com.buffermanagement.observer;

/**
 * Design pattern: Observer design pattern.
 * 
 * @author borde
 *
 */
public abstract class Observer {
	   protected int runCount;

	   public abstract void update(int startVal);

}