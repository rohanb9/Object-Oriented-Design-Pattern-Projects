package com.buffermanagement.state;

import com.buffermanagement.classes.BoundedBuffer;
import com.buffermanagement.exception.BBException;

public class WriteState implements State {

   private int v;
   public synchronized int doAction(BoundedBuffer context) throws BBException {
      System.out.println("					(BoundedBuffer in write state)");
      context.setState(this);
      
      if(!context.isFull()) {

    	  	int end = context.getEnd();
    	  	int[] buff = context.getBuff();
    	  	 
			end = (end + 1) % context.getBuffSize();
			context.setEnd(end);
			buff[end] = v;
			context.setBuff(buff);
			int currentSize = context.getCurrentSize() + 1;
			
			context.setCurrentSize(currentSize);
			

			//System.out.println(" start " + start + "  end " + end + " curr " + currentSize);
			//printBuffer();
		} else {
			throw new BBException("Buffer is full.");
		}
      return 0;	
   }

   public String toString(){
      return "Write State";
   }

	public void setValue(int v) {
		this.v = v;
	}
}