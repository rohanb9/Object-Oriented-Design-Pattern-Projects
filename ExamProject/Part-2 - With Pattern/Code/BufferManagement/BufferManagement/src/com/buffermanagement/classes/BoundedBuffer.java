package com.buffermanagement.classes;

import com.buffermanagement.state.State;

/**
 * Design pattern : Singleton has been used.
 * 
 * @author borde
 *
 */

public class BoundedBuffer {
	private int buff[] = new int[3];
	private int buffSize = 3;
	
	private int start=0;
	private int end=-1;
	private int currentSize = 0;

    //create an object of SingleObject
    private static BoundedBuffer obj;
    
    private State state;

	//make the constructor private so that this class cannot be
	//instantiated
	private BoundedBuffer(){}
	  
	//Get the only object available
	 public static synchronized BoundedBuffer getInstance()
	  {
	        if (obj==null)
	            obj = new BoundedBuffer();
	        return obj;
	 }
	 
	 // Clone not supported
	 public Object clone() throws CloneNotSupportedException {
		 throw new CloneNotSupportedException();
	 }
	
	public boolean isEmpty() {
		if(currentSize <= 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(buffSize == currentSize) {
			return true;
		}
		return false;
	}
	
	public void printBuffer() {
		System.out.println("BUFFER -> " + toString());
		/*for(int i=0; i<=(buffSize) ; i++ ) {
	
			System.out.println(" i, " + buff[i] );
		}*/
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		int i = 0; 
		int j = start;
		while(i < currentSize) {
			str.append(Integer.toString(buff[j]) + " ");
			j = (j+1) % buffSize;
			i++;
		}
		return str.toString();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int[] getBuff() {
		return buff;
	}

	public void setBuff(int[] buff) {
		this.buff = buff;
	}

	public int getBuffSize() {
		return buffSize;
	}

	public void setBuffSize(int buffSize) {
		this.buffSize = buffSize;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}
	
	
}
